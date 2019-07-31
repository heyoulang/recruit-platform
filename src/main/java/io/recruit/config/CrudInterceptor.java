package io.recruit.config;

import io.recruit.common.annotation.TableFill;
import io.recruit.common.constant.TableField;
import io.recruit.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.shiro.SecurityUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Mybatis CRUD拦截器
 *
 * @author Duke.Li
 * @data 2018-04-26 15:20
 */
@ConditionalOnClass(Interceptor.class)
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class CrudInterceptor implements Interceptor {
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        
        Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        Object parameter = args[1];
        
        SqlCommandType type = statement.getSqlCommandType();
        
        if (SqlCommandType.SELECT.equals(type)) {
        
        } else {
            
            if (parameter instanceof MapperMethod.ParamMap) {
                
                parameter = ((MapperMethod.ParamMap) parameter).get("param1");
            } else if (parameter instanceof DefaultSqlSession.StrictMap) {
                
                parameter = ((DefaultSqlSession.StrictMap) parameter).get("collection");
            }
            
            if (parameter instanceof Collection) {
                
                
                ((Collection) parameter).stream().forEach(object -> {
                    
                    try {
                        fillObject(object, type);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                
                fillObject(parameter, type);
            }
            
        }
        
        return invocation.proceed();
    }
    
    /**
     * 填充对象
     *
     * @param parameter
     * @param type
     * @throws IllegalAccessException
     */
    private void fillObject(Object parameter, SqlCommandType type) throws IllegalAccessException {
        
        List<Field> fills = new ArrayList<>();
        
        Class<?> parameterClass = parameter.getClass();
        
        Field[] fields = parameterClass.getDeclaredFields();
        for (Field field : fields) {
            
            switch (type) {
                
                
                case INSERT:
                    
                    // 存在Id主键，并且存在KeyGenerator主键自动赋值主键
                    /*KeyGenerator keyGenerator = field.getAnnotation(KeyGenerator.class);
                    if (field.isAnnotationPresent(Id.class) && keyGenerator != null) {
                        
                        field.setAccessible(true);
                        switch (keyGenerator.key()) {
                            case UUID:
                                field.set(parameter, UUID.randomUUID().toString().replaceAll("-", ""));
                                break;
                            case ID_WORKER:
                                field.set(parameter, snowflakeKey.nextId());
                                break;
                            case NONE:
                        }
                    }*/
                    
                    if (field.getAnnotation(TableFill.class) != null) {
                        
                        fills.add(field);
                    }
                    
                    break;
                case UPDATE:
                    
                    if (field.getAnnotation(TableFill.class) != null) {
                        
                        fills.add(field);
                    }
                    
                    break;
            }
        }
        
        if (fills != null && fills.size() > 0) {
            
            for (Field field : fills) {
    
                fillObject(type, parameter, field);
            }
        } else {
            
            TableFill tableFill = parameterClass.getAnnotation(TableFill.class);
            // 判断是否需要全部自动填充
            if (tableFill != null) {
                
                for (Field field : parameterClass.getDeclaredFields()) {
    
                    fillObject(type, parameter, field);
                }
            }
        }
    }
    
    /**
     * 填充
     *
     * @param parameter
     * @param field
     * @throws IllegalAccessException
     */
    private void fillObject(SqlCommandType type, Object parameter, Field field) throws IllegalAccessException {
        
        TableField fieldFill = TableField.from(field.getName());
        if (fieldFill != null) {
            
            field.setAccessible(true);

            SysUserEntity user = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
            if (user == null)
                user = new SysUserEntity();
            
            switch (type) {
                
                case INSERT:
                    
                    switch (fieldFill) {
    
                        case createName:
                            field.set(parameter, user.getUsername());
                            break;
                        case createTime:
                            field.set(parameter, new Date());
                            break;
                    }
                    
                case UPDATE:
                    
                    switch (fieldFill) {
    
                        case updateName:
                            field.set(parameter, user.getUsername());
                            break;
                        case updateTime:
                            field.set(parameter, new Date());
                            break;
                    }
            }
        }
        
    }
    
    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }
    
    @Override
    public void setProperties(Properties properties) {
    
    }
}

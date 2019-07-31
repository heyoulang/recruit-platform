package io.recruit.common.annotation;

import io.recruit.common.constant.FieldFill;
import io.recruit.common.constant.TableField;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author LiXiang
 * @data 2018-07-31 16:28
 */
@Target({TYPE, FIELD})
@Retention(RUNTIME)
public @interface TableFill {
    
    /**
     * 填充字段
     * @return
     */
    TableField[] name() default TableField.all;
    
    /**
     * 填充类型
     * @return
     */
    FieldFill type() default FieldFill.BOTH;
}

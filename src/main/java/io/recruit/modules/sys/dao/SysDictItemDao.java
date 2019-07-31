package io.recruit.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.recruit.modules.sys.entity.SysDictItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-29 18:53:55
 */
@Mapper
public interface SysDictItemDao extends BaseMapper<SysDictItemEntity> {

    /**
     * 根据父类编号查询字典小项
     * @param dictId
     * @return
     */
    @Select("SELECT * FROM sys_dict_item WHERE dict_id = #{dictId} ORDER BY sort_order")
    List<SysDictItemEntity> queryItemByDictId(Integer dictId);
}

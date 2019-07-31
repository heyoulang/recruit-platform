package io.recruit.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.recruit.modules.sys.dto.DictTypeDTO;
import io.recruit.modules.sys.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-29 18:53:55
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {

    /**
     * 查询所有字典类别
     * @return
     */
    List<DictTypeDTO> queryAll();
}

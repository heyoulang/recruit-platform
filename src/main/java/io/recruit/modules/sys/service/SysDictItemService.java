package io.recruit.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.recruit.common.utils.PageUtils;
import io.recruit.modules.sys.entity.SysDictItemEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-29 18:53:55
 */
public interface SysDictItemService extends IService<SysDictItemEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据父类编号查询字典小项
     * @param dictId
     * @return
     */
    List<SysDictItemEntity> queryItemByDictId(Integer dictId);
}


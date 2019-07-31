package io.recruit.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.recruit.common.utils.PageUtils;
import io.recruit.modules.sys.entity.SysDictEntity;

import java.util.Map;

/**
 * 
 *
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-29 18:53:55
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


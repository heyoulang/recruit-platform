package io.recruit.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.recruit.common.utils.PageUtils;
import io.recruit.modules.manage.entity.RcRecruitInfoEntity;

import java.util.Map;

/**
 * 招聘信息表
 *
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-30 20:58:50
 */
public interface RcRecruitInfoService extends IService<RcRecruitInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


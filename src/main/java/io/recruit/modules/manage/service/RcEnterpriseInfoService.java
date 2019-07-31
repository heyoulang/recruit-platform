package io.recruit.modules.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.recruit.common.utils.PageUtils;
import io.recruit.modules.manage.entity.RcEnterpriseInfoEntity;

import java.util.Map;

/**
 * 招聘-企业表
 *
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-30 20:58:51
 */
public interface RcEnterpriseInfoService extends IService<RcEnterpriseInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加企业
     */
    void addEnterprise(RcEnterpriseInfoEntity entity);

    /**
     * 修改企业
     */
    void editEnterprise(RcEnterpriseInfoEntity entity);
}


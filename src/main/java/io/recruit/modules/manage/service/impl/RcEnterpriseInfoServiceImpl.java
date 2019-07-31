package io.recruit.modules.manage.service.impl;

import io.recruit.common.utils.BaseUtils;
import io.recruit.common.validator.Assert;
import io.recruit.common.validator.ValidatorUtils;
import io.recruit.common.validator.group.AddGroup;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.Query;

import io.recruit.modules.manage.dao.RcEnterpriseInfoDao;
import io.recruit.modules.manage.entity.RcEnterpriseInfoEntity;
import io.recruit.modules.manage.service.RcEnterpriseInfoService;


@Service("rcEnterpriseInfoService")
public class RcEnterpriseInfoServiceImpl extends ServiceImpl<RcEnterpriseInfoDao, RcEnterpriseInfoEntity> implements RcEnterpriseInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RcEnterpriseInfoEntity> page = this.page(
                new Query<RcEnterpriseInfoEntity>().getPage(params),
                new QueryWrapper<RcEnterpriseInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void addEnterprise(RcEnterpriseInfoEntity entity) {
        ValidatorUtils.validateEntity(entity, AddGroup.class);
        this.checkName(entity.getEnterpriseName());
        entity.setEnterpriseNo(BaseUtils.getNumber().toString());
        this.save(entity);
    }

    @Override
    public void editEnterprise(RcEnterpriseInfoEntity entity) {
        if (StringUtils.isNotBlank(entity.getEnterpriseName())) {
            this.checkName(entity.getEnterpriseName());
        }
        this.updateById(entity);
    }

    /**
     * 验证企业名字是否存在
     * @param enterpriseName
     */
    private void checkName(String enterpriseName) {
        RcEnterpriseInfoEntity hisInfo = this.getOne(new QueryWrapper<RcEnterpriseInfoEntity>()
                .eq("enterprise_name", enterpriseName.trim()));
        Assert.notNull(hisInfo, "该企业名字已存在");
    }
}
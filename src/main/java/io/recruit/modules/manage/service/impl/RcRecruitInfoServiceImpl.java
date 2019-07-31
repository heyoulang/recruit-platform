package io.recruit.modules.manage.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.Query;

import io.recruit.modules.manage.dao.RcRecruitInfoDao;
import io.recruit.modules.manage.entity.RcRecruitInfoEntity;
import io.recruit.modules.manage.service.RcRecruitInfoService;


@Service("rcRecruitInfoService")
public class RcRecruitInfoServiceImpl extends ServiceImpl<RcRecruitInfoDao, RcRecruitInfoEntity> implements RcRecruitInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RcRecruitInfoEntity> page = this.page(
                new Query<RcRecruitInfoEntity>().getPage(params),
                new QueryWrapper<RcRecruitInfoEntity>()
        );

        return new PageUtils(page);
    }

}
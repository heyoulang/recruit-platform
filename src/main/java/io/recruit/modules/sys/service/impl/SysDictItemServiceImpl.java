package io.recruit.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.Query;
import io.recruit.modules.sys.dao.SysDictItemDao;
import io.recruit.modules.sys.entity.SysDictItemEntity;
import io.recruit.modules.sys.service.SysDictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysDictItemService")
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemDao, SysDictItemEntity> implements SysDictItemService {

    @Autowired
    private SysDictItemDao dictItemDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDictItemEntity> page = this.page(
                new Query<SysDictItemEntity>().getPage(params),
                new QueryWrapper<SysDictItemEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SysDictItemEntity> queryItemByDictId(Integer dictId) {
        return dictItemDao.queryItemByDictId(dictId);
    }
}
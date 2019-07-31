/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.recruit.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.Query;
import io.recruit.modules.oss.dao.SysOssDao;
import io.recruit.modules.oss.entity.SysOssEntity;
import io.recruit.modules.oss.service.SysOssService;
import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.Query;
import io.recruit.modules.oss.dao.SysOssDao;
import io.recruit.modules.oss.entity.SysOssEntity;
import io.recruit.modules.oss.service.SysOssService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<SysOssEntity> page = this.page(
			new Query<SysOssEntity>().getPage(params)
		);

		return new PageUtils(page);
	}
	
}
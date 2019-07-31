package io.recruit.modules.manage.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.recruit.modules.manage.entity.RcRecruitInfoEntity;
import io.recruit.modules.manage.service.RcRecruitInfoService;
import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.R;



/**
 * 招聘信息表
 *
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-30 20:58:50
 */
@RestController
@RequestMapping("manage/rcrecruitinfo")
public class RcRecruitInfoController {

    @Autowired
    private RcRecruitInfoService rcRecruitInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    // @RequiresPermissions("manage:rcrecruitinfo:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = rcRecruitInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{rcId}")
    // @RequiresPermissions("manage:rcrecruitinfo:info")
    public R info(@PathVariable("rcId") Integer rcId){
		RcRecruitInfoEntity rcRecruitInfo = rcRecruitInfoService.getById(rcId);

        return R.ok().put("rcRecruitInfo", rcRecruitInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    // @RequiresPermissions("manage:rcrecruitinfo:save")
    public R save(@RequestBody RcRecruitInfoEntity rcRecruitInfo){
		rcRecruitInfoService.save(rcRecruitInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    // @RequiresPermissions("manage:rcrecruitinfo:update")
    public R update(@RequestBody RcRecruitInfoEntity rcRecruitInfo){
		rcRecruitInfoService.updateById(rcRecruitInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    // @RequiresPermissions("manage:rcrecruitinfo:delete")
    public R delete(@RequestBody Integer[] rcIds){
		rcRecruitInfoService.removeByIds(Arrays.asList(rcIds));

        return R.ok();
    }

}

package io.recruit.modules.manage.controller;

import java.util.Arrays;
import java.util.Map;

import io.recruit.common.validator.ValidatorUtils;
import io.recruit.common.validator.group.AddGroup;
import io.recruit.modules.app.entity.UserEntity;
import io.recruit.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.recruit.modules.manage.entity.RcEnterpriseInfoEntity;
import io.recruit.modules.manage.service.RcEnterpriseInfoService;
import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.R;



/**
 * 招聘-企业表
 *
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-30 20:58:51
 */
@Api(value = "企业相关管理", description = "企业相关管理")
@RestController
@RequestMapping("manage/rcenterpriseinfo")
public class RcEnterpriseInfoController {

    @Autowired
    private RcEnterpriseInfoService rcEnterpriseInfoService;

    /**
     * 列表
     */
    @GetMapping("/list")
    // @RequiresPermissions("manage:rcenterpriseinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = rcEnterpriseInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{epId}")
    // @RequiresPermissions("manage:rcenterpriseinfo:info")
    public R info(@PathVariable("epId") Integer epId){
		RcEnterpriseInfoEntity rcEnterpriseInfo = rcEnterpriseInfoService.getById(epId);

        return R.ok().put("rcEnterpriseInfo", rcEnterpriseInfo);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增企业信息", notes = "新增企业信息")
    @PostMapping("/save")
    // @RequiresPermissions("manage:rcenterpriseinfo:save")
    public R save(@RequestBody RcEnterpriseInfoEntity rcEnterpriseInfo){

		rcEnterpriseInfoService.addEnterprise(rcEnterpriseInfo);
        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改企业信息", notes = "修改企业信息")
    @PutMapping("/update")
    // @RequiresPermissions("manage:rcenterpriseinfo:update")
    public R update(@RequestBody RcEnterpriseInfoEntity rcEnterpriseInfo){

        rcEnterpriseInfoService.editEnterprise(rcEnterpriseInfo);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    // @RequiresPermissions("manage:rcenterpriseinfo:delete")
    public R delete(@RequestBody Integer[] epIds){

		rcEnterpriseInfoService.removeByIds(Arrays.asList(epIds));
        return R.ok();
    }

}

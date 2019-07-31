package io.recruit.modules.sys.controller;

import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.R;
import io.recruit.modules.sys.core.DictHandel;
import io.recruit.modules.sys.entity.SysDictEntity;
import io.recruit.modules.sys.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 
 *
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-29 18:53:55
 */
@Api(value = "字典类型", description = "字典分类")
@RestController
@RequestMapping("sys/sysdict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private DictHandel dictHandel;

    /**
     * 列表
     */
    @ApiOperation(value = "查询字典列表", notes = "字典类别列表")
    @GetMapping("/list")
    // @RequiresPermissions("sys:sysdict:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDictService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "字典类别详情", notes = "字典类别详情")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("sys:sysdict:info")
    public R info(@PathVariable("id") Integer id){
		SysDictEntity sysDict = sysDictService.getById(id);

        return R.ok().put("sysDict", sysDict);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增字典类别", notes = "新增字典类别")
    @PostMapping("/save")
    // @RequiresPermissions("sys:sysdict:save")
    public R save(@RequestBody SysDictEntity sysDict){
		sysDictService.save(sysDict);
        dictHandel.init();
        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改字典类别", notes = "修改字典类别")
    @PutMapping("/update")
    // @RequiresPermissions("sys:sysdict:update")
    public R update(@RequestBody SysDictEntity sysDict){
		sysDictService.updateById(sysDict);
        dictHandel.init();
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除字典类别", notes = "删除字典类别")
    @DeleteMapping("/delete")
    // @RequiresPermissions("sys:sysdict:delete")
    public R delete(@RequestBody Integer[] ids){
		sysDictService.removeByIds(Arrays.asList(ids));
        dictHandel.init();
        return R.ok();
    }

}

package io.recruit.modules.sys.controller;

import io.recruit.common.utils.PageUtils;
import io.recruit.common.utils.R;
import io.recruit.common.validator.Assert;
import io.recruit.modules.sys.core.DictHandel;
import io.recruit.modules.sys.entity.SysDictEntity;
import io.recruit.modules.sys.entity.SysDictItemEntity;
import io.recruit.modules.sys.service.SysDictItemService;
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
@Api(value = "数据字典小项", description = "数据字典小项 (跟大类一对多)")
@RestController
@RequestMapping("sys/sysdictitem")
public class SysDictItemController {

    @Autowired
    private SysDictItemService sysDictItemService;

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private DictHandel dictHandel;

    /**
     * 列表
     */
    @ApiOperation(value = "查询小项列表", notes = "查询小项列表")
    @GetMapping("/list")
    // @RequiresPermissions("sys:sysdictitem:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDictItemService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查询小项详情", notes = "查询小项详情")
    @GetMapping("/info/{id}")
    // @RequiresPermissions("sys:sysdictitem:info")
    public R info(@PathVariable("id") Integer id){
		SysDictItemEntity sysDictItem = sysDictItemService.getById(id);

        return R.ok().put("sysDictItem", sysDictItem);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增小项详情", notes = "新增小项详情")
    @PostMapping("/save")
    // @RequiresPermissions("sys:sysdictitem:save")
    public R save(@RequestBody SysDictItemEntity sysDictItem){
        Assert.isNull(sysDictItem.getDictId(), "父类编号必须");
        SysDictEntity dict = sysDictService.getById(sysDictItem.getDictId());
        Assert.isNull(dict, "父类不存在");
        sysDictItemService.save(sysDictItem);
        dictHandel.init();
        return R.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改小项信息", notes = "修改小项信息")
    @PutMapping("/update")
    // @RequiresPermissions("sys:sysdictitem:update")
    public R update(@RequestBody SysDictItemEntity sysDictItem){
		sysDictItemService.updateById(sysDictItem);
        dictHandel.init();
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除小项信息", notes = "删除小项信息")
    @DeleteMapping("/delete")
    // @RequiresPermissions("sys:sysdictitem:delete")
    public R delete(@RequestBody Integer[] ids){
		sysDictItemService.removeByIds(Arrays.asList(ids));
        dictHandel.init();
        return R.ok();
    }

    @ApiOperation(value = "根据分类编号查询小项", notes = "根据分类编号查询小项")
    @GetMapping("queryItemByDictId/{dictId}")
    public R queryItemByDictId(@PathVariable("dictId") Integer dictId) {

        return R.ok().put("items", sysDictItemService.queryItemByDictId(dictId));
    }

    @ApiOperation(value = "前端所有页面获取字典项的接口", notes = "前端所有页面获取字典项的接口")
    @GetMapping("queryItemByDictCode/{dictCode}")
    public R queryItemByDictCode(@PathVariable("dictCode") String dictCode) {

        return R.ok().put("items", dictHandel.getCacheDictItem(dictCode));
    }
}

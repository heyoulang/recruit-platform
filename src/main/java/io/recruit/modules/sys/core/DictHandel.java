package io.recruit.modules.sys.core;

import cn.hutool.json.JSONUtil;
import io.recruit.common.validator.Assert;
import io.recruit.modules.sys.dao.SysDictDao;
import io.recruit.modules.sys.dto.DictTypeDTO;
import io.recruit.modules.sys.entity.SysDictItemEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author youlang.he
 * @Title: ${file_name}
 * @date 2019/7/30 14:37
 */
@Slf4j
@Component
public class DictHandel {

    @Autowired
    private SysDictDao sysDictDao;

    /**
     * 缓存字典 后续用redis代替
     */
    private HashMap<String, DictTypeDTO> dictMap = new HashMap<>();

    @PostConstruct
    public void init() {
        log.info(">>>>>> 【启动加载数据字典】");
        long start = System.currentTimeMillis();
        List<DictTypeDTO> dictTypeDTOS = sysDictDao.queryAll();
        dictTypeDTOS.forEach(dictTypeDTO -> {
            dictMap.put(dictTypeDTO.getDictCode(), dictTypeDTO);
        });
        log.info(">>>>>> 【数据字典加载完成】，耗时：{} ms", System.currentTimeMillis() - start);
    }

    /**
     * 获取缓存字典
     * @param dictCode
     * @return
     */
    public List<SysDictItemEntity> getCacheDictItem(String dictCode) {
        Assert.isBlank(dictCode, "字典编码不能为空");
        DictTypeDTO dto = dictMap.get(dictCode);
        if (dto == null)
            return Collections.emptyList();
        return dto.getItems();
    }
}

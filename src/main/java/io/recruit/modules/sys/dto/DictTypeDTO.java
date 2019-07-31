package io.recruit.modules.sys.dto;

import io.recruit.modules.sys.entity.SysDictItemEntity;
import lombok.Data;

import java.util.List;

/**
 * @author youlang.he
 * @Title: ${file_name}
 * @date 2019/7/30 14:43
 */
@Data
public class DictTypeDTO {

    private Integer id;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 字典编码
     */
    private String dictCode;
    /**
     * 描述
     */
    private String description;
    /**
     * 删除状态
     */
    private Integer delFlag;

    /**
     * 子项
     */
    List<SysDictItemEntity> items;
}

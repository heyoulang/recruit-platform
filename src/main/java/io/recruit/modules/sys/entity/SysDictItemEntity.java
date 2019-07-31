package io.recruit.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-29 18:53:55
 */
@Data
@TableName("sys_dict_item")
public class SysDictItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 字典id
	 */
	private Integer dictId;
	/**
	 * 字典项文本
	 */
	private String itemText;
	/**
	 * 字典项值
	 */
	private String itemValue;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer sortOrder;
	/**
	 * 状态（1启用 0不启用）
	 */
	private Integer status;
	/**
	 * 创建人
	 */
	private String createName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新人
	 */
	private String updateName;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}

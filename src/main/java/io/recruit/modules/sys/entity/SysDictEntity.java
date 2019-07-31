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
@TableName("sys_dict")
public class SysDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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

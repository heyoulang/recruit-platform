package io.recruit.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 招聘信息表
 * 
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-30 20:58:50
 */
@Data
@TableName("rc_recruit_info")
public class RcRecruitInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer rcId;
	/**
	 * 企业编号
	 */
	private Integer epId;
	/**
	 * 招聘状态
	 */
	private Integer recruitStatus;
	/**
	 * 招聘人数
	 */
	private Integer recruitNum;
	/**
	 * 工作岗位
	 */
	private String post;
	/**
	 * 虚拟报名人数
	 */
	private Integer invalidSignNum;
	/**
	 * 薪水
	 */
	private String salary;
	/**
	 * 自定义列
	 */
	private String customColumn;
	/**
	 * 标签
	 */
	private String label;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 * 截止日期
	 */
	private Date invalidTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 
	 */
	private String createName;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String updateName;
	/**
	 * 
	 */
	private Date updateTime;

}

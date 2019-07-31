package io.recruit.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.recruit.common.annotation.TableFill;
import io.recruit.common.validator.group.AddGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 招聘-企业表
 * 
 * @author heyoulang
 * @email 453819520@qq.com
 * @date 2019-07-30 20:58:51
 */
@Data
@TableFill
@TableName("rc_enterprise_info")
public class RcEnterpriseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer epId;
	/**
	 * 企业名称
	 */
	@NotBlank(message = "企业名称必须", groups = {AddGroup.class})
	private String enterpriseName;
	/**
	 * 企业编号
	 */
	private String enterpriseNo;
	/**
	 * 1：启用，2：禁用
	 */
	private Integer iflag;
	/**
	 * 企业地址
	 */
	@NotBlank(message = "企业地址必须", groups = {AddGroup.class})
	private String address;
	/**
	 * 签订人
	 */
	@NotBlank(message = "签订人必须", groups = {AddGroup.class})
	private String signName;
	/**
	 * 
	 */
	@NotNull(message = "签订日期必须", groups = {AddGroup.class})
	private Date signTime;
	/**
	 * 
	 */
	private String epDetail;
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

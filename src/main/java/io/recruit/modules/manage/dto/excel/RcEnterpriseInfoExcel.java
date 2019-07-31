package io.recruit.modules.manage.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.recruit.common.constant.DateConstant;
import io.recruit.common.constant.IflagEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author youlang.he
 * @Title: 企业excel导出
 * @date 2019/7/31 11:25
 */
@Data
public class RcEnterpriseInfoExcel extends BaseRowModel {

    /**
     * 企业名称
     */
    @ExcelProperty(value = "企业名称", index = 0)
    private String enterpriseName;
    /**
     * 企业编号
     */
    @ExcelProperty(value = "企业编号", index = 1)
    private String enterpriseNo;
    /**
     * 1：启用，2：禁用
     */
    @ExcelProperty(value = "状态", index = 2)
    private String iflag;
    /**
     * 企业地址
     */
    @ExcelProperty(value = "企业地址", index = 3)
    private String address;
    /**
     * 签订人
     */
    @ExcelProperty(value = "签订人", index = 4)
    private String signName;
    /**
     *
     */
    @ExcelProperty(value = "签订日期", index = 5, format = DateConstant.DATE_TIME_PATTERN)
    private Date signTime;
    /**
     *
     */
    @ExcelProperty(value = "备注", index = 6)
    private String epDetail;
    /**
     *
     */
    @ExcelProperty(value = "创建人", index = 7)
    private String createName;
    /**
     *
     */
    @ExcelProperty(value = "创建时间", index = 8, format = DateConstant.DATE_TIME_PATTERN)
    private Date createTime;

    public void setIflag(Integer iflag) {
        if (IflagEnum.Enable.code.equals(iflag))
            this.iflag = "启用";
        else
            this.iflag = "禁用";
    }
}

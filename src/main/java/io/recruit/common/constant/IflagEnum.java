package io.recruit.common.constant;

/**
 * @author youlang.he
 * @Title: ${file_name}
 * @date 2019/7/31 11:29
 */
public enum IflagEnum {

    Enable(1), Disable(0);

    public Integer code;

    IflagEnum(Integer code) {
        this.code = code;
    }
}

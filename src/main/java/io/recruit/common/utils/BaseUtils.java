package io.recruit.common.utils;

/**
 * @author youlang.he
 * @Title: ${file_name}
 * @date 2019/7/30 21:26
 */
public class BaseUtils {

    private static SnowflakeIdWorker worker = new SnowflakeIdWorker(1,1);

    /**
     * 获取不重复编号
     * @return
     */
    public static Long getNumber() {
        return worker.nextId();
    }
}

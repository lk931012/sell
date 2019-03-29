package com.study.sell.common.utils;

import com.study.sell.common.enums.BaseEnum;

/**
 * 枚举工具类
 *
 * @Auther : 冷科
 * @Date : 2019/3/14 01:41
 */
public class EnumUtil {
    /**
     * 通过code从枚举类里获取一个枚举
     *
     * @param enumClass 枚举类
     * @return 返回一个枚举类里一个code相匹配的枚举 ,如果不匹配则返回null
     */
    public static <T extends BaseEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}

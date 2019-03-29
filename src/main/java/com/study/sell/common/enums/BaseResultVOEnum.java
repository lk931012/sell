package com.study.sell.common.enums;

import lombok.Getter;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 01:53
 */
@Getter
public enum BaseResultVOEnum {
    SUCCESS(0, "成功!"),
    ERROR(1, "失败!");
    private Integer code;
    private String msg;

    BaseResultVOEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
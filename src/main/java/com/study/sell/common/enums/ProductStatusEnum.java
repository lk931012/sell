package com.study.sell.common.enums;

import lombok.Getter;

/**
 * 产品状态枚举类
 *
 * @Auther : 冷科
 * @Date : 2019/3/10 00:48
 */
@Getter
public enum ProductStatusEnum implements BaseEnum {
    UP(0, "上架"),
    DOWN(1, "下架");
    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

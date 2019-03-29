package com.study.sell.common.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 *
 * @Auther : 冷科
 * @Date : 2019/3/10 01:53
 */
@Getter
public enum OrderStatusEnum implements BaseEnum {
    NEW(0, "新下单"),
    FINISH(1, "已完结"),
    CANCEL(2, "已取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

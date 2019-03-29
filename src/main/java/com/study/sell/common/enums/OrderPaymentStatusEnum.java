package com.study.sell.common.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 *
 * @Auther : 冷科
 * @Date : 2019/3/10 01:53
 */
@Getter
public enum OrderPaymentStatusEnum implements BaseEnum {
    NON_PAYMENT(0, "未支付"),//未支付状态,默认状态
    PAID(1, "已支付");//已经支付

    private Integer code;
    private String msg;

    OrderPaymentStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

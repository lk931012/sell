package com.study.sell.common.enums;

import lombok.Data;
import lombok.Getter;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 异常信息枚举
 *
 * @Auther : 冷科
 * @Date : 2019/3/11 01:05
 */
@Getter
public enum ExceptionEnum {
    NULL_ORDER(1001, "订单不存在!"),
    ORDER_STATUS_ERROR(1011, "订单状态异常!"),
    PARAM_EXCEPTION(1201, "参数异常!"),
    WX_GET_ACCESS_TOKEN_EXCEPTION(1301, "微信获取access_token异常!"),
    WX_GET_USER_INFO_EXCEPTION(1301, "微信获取用户信息异常!");
    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

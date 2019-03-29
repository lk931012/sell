package com.study.sell.common.exception;

/**
 * 用户登录状态切面检测异常
 *
 * @Auther : 冷科
 * @Date : 2019/3/18 13:26
 */
public class UserAutoException extends RuntimeException {
    private Integer code;
    private String msg;

    public UserAutoException(String msg) {
        super(msg);
    }
}

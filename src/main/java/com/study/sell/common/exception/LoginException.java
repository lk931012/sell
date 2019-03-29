package com.study.sell.common.exception;

/**
 * @Auther : 冷科
 * @Date : 2019/3/18 09:37
 */
public class LoginException extends RuntimeException {
    private Integer code;
    private String msg;

    public LoginException(String msg) {
        super(msg);
    }
}

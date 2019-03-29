package com.study.sell.common.exception;

import lombok.Data;

/**
 * 自定义异常
 *
 * @Auther : 冷科
 * @Date : 2019/3/11 01:00
 */
@Data
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(String msg) {
        super(msg);
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}

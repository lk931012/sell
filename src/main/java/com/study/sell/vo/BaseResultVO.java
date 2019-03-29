package com.study.sell.vo;

import com.study.sell.common.enums.BaseResultVOEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 01:47
 */
@Data
public class BaseResultVO<T> implements Serializable {

    private static final long serialVersionUID = -5369035559833563010L;

    private Integer code;   //返回状态
    private String msg;       //返回描述
    private T data;           //返回数据

    private BaseResultVO(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    private BaseResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private BaseResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 返回成功结果
     */
    public static <T> BaseResultVO<T> success() {
        return new BaseResultVO(BaseResultVOEnum.SUCCESS.getCode(), BaseResultVOEnum.SUCCESS.getMsg());
    }

    public static <T> BaseResultVO<T> success(T data) {
        return new BaseResultVO(BaseResultVOEnum.SUCCESS.getCode(), BaseResultVOEnum.SUCCESS.getMsg(), data);
    }

    public static <T> BaseResultVO<T> success(String msg) {
        return new BaseResultVO(BaseResultVOEnum.SUCCESS.getCode(), msg);
    }

    public static <T> BaseResultVO<T> success(String msg, T data) {
        return new BaseResultVO(BaseResultVOEnum.SUCCESS.getCode(), msg, data);
    }

    /**
     * 返回失败结果
     */
    public static <T> BaseResultVO<T> error(String msg) {
        return new BaseResultVO(BaseResultVOEnum.ERROR.getCode(), msg);
    }
}

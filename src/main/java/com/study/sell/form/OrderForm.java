package com.study.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * 接收前台传递的订单参数 并做表单验证
 *
 * @Auther : 冷科
 * @Date : 2019/3/11 02:44
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填!")
    private String name;
    @NotEmpty(message = "电话号码必填!")
    private String phone;
    @NotEmpty(message = "地址必填!")
    private String address;
    @NotEmpty(message = "微信号必填!")
    private String openid;

    @NotEmpty(message = "购物车不能为空!")
    private String items;              //订单详情集合,json格式
}

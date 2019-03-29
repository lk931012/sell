package com.study.sell.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.sell.common.enums.OrderPaymentStatusEnum;
import com.study.sell.common.enums.OrderStatusEnum;
import com.study.sell.common.utils.EnumUtil;
import com.study.sell.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单数据传输对象
 * 结合了订单OrderMaster以及OrderDetail
 *
 * @Auther : 冷科
 * @Date : 2019/3/10 21:32
 */
@Data
public class OrderDTO {

    private String orderId;            //订单ID
    private String buyerName;           //买家名字
    private String buyerPhone;          //买家电话
    private String buyerAddress;        //买家地址
    private String buyerOpenid;         //买家微信ID
    private BigDecimal orderAmount;     //订单总金额
    private Integer orderStatus;    //订单状态,默认0,新下单
    private Integer paymentStatus;          //支付状态,默认0,未支付
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;            //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;            //更新时间
    private List<OrderDetail> orderDetailList;


    //返回订单状态的msg描述
    @JsonIgnore
    public String getOrderStatusMsg() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class).getMsg();
    }

    //返回订单支付状态的msg描述
    @JsonIgnore
    public String getPaymentStatusMsg() {
        return EnumUtil.getByCode(paymentStatus, OrderPaymentStatusEnum.class).getMsg();
    }
}

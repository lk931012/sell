package com.study.sell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.sell.common.enums.OrderPaymentStatusEnum;
import com.study.sell.common.enums.OrderStatusEnum;
import com.study.sell.common.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 15:12
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;            //订单ID
    private String buyerName;           //买家名字
    private String buyerPhone;          //买家电话
    private String buyerAddress;        //买家地址
    private String buyerOpenid;         //买家微信ID
    private BigDecimal orderAmount;     //订单总金额
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();            //订单状态,默认0,新下单
    private Integer paymentStatus = OrderPaymentStatusEnum.NON_PAYMENT.getCode();          //支付状态,默认0,未支付
    private Date createTime;            //创建时间
    private Date updateTime;            //更新时间


}

package com.study.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class OrderDetail {
    @Id
    private String detailId;            //订单详情ID
    private String orderId;             //订单ID
    private String productId;           //商品ID
    private String productName;         //商品名称
    private BigDecimal productPrice;    //商品价格
    private Integer productQuantity;    //商品购买数量
    private String productIcon;         //商品小图
    private Date createTime;            //创建日期
    private Date updateTime;            //修改日期
}

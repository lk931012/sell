package com.study.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品信息实体VO
 *
 * @Auther : 冷科
 * @Date : 2019/3/9 15:10
 */

@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 5842682185520473466L;
    @JsonProperty("id")
    private String productId;           //商品ID
    @JsonProperty("name")
    private String productName;         //商品名称
    @JsonProperty("price")
    private BigDecimal productPrice;    //商品价格
    @JsonProperty("description")
    private String productDescription;         //商品描述
    @JsonProperty("icon")
    private String productIcon;                //商品小图
}

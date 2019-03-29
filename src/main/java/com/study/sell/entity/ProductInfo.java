package com.study.sell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.sell.common.enums.ProductStatusEnum;
import com.study.sell.common.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 15:10
 * 产品信息实体
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 4293961826353792955L;
    @Id
    private String productId;           //商品ID
    private String productName;         //商品名称
    private BigDecimal productPrice;    //商品价格
    private Short discount;             //商品折扣
    private BigDecimal discountValue;    //折扣后价格
    private Integer productStock;                  //库存
    private String productDescription;         //商品描述
    private String productIcon;                //商品小图
    private Integer productStatus;                 //状态
    private Integer categoryType;                //分类编号
    private Date createTime;              //创建日期
    private Date updateTime;              //修改日期

    //获取商品状态的文字描述
    @JsonIgnore
    public String getStatusMsg() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class).getMsg();
    }
}

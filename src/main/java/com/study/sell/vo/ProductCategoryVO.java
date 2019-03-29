package com.study.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.study.sell.entity.ProductInfo;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * 产品类目VO
 *
 * @Auther : 冷科
 * @Date : 2019/3/9 15:11
 */
@Data
public class ProductCategoryVO implements Serializable {

    private static final long serialVersionUID = -5863571204481839304L;
    //类目名称;
    @JsonProperty("name")//json转换后将以name名字展示。
    private String categoryName;
    //分类编号;
    @JsonProperty("type")
    private Integer categoryType;
    //该类目下的商品
    private List<ProductInfo> foods;
}

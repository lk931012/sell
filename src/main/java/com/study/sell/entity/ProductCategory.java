package com.study.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 15:11
 * 产品类目实体
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = -5514213762425951149L;
    @Id
    @GeneratedValue
    //类目ID;
    private Integer categoryId;
    //类目名称;
    private String categoryName;
    //分类编号;
    private Integer categoryType;
}

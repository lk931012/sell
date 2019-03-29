package com.study.sell.service;

import com.study.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 00:14
 */
public interface ProductInfoService {
    /**
     * 查询上架商品
     */
    List<ProductInfo> findUpAll();

    /**
     * 通过商品分类编号查询
     */
    List<ProductInfo> findByCategotyType(Integer integer);

    void save(ProductInfo productInfo);

    ProductInfo findById(String string);

    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 加库存
     */

}

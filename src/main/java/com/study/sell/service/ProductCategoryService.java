package com.study.sell.service;

import com.study.sell.entity.ProductCategory;

import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 23:12
 */
public interface ProductCategoryService {

    /**
     * 通过分类名称查找产品分类
     */
    ProductCategory findById(Integer integer);

    /**
     * 通过分类名称查找产品分类
     */
    ProductCategory findByCategoryName(String string);

    /**
     * 通过分类编号查找产品分类
     */
    ProductCategory findByCategoryType(Integer integer);

    /**
     * 通过分类编号集合查找产品分类
     */
    List<ProductCategory> findByCategoryTypes(List<Integer> types);

    /**
     * 查找所有产品分类
     */
    List<ProductCategory> findAll();


    /**
     * 新增产品分类
     */
    void save(ProductCategory productCategory);
}

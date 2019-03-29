package com.study.sell.repostory;

import com.study.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 15:43
 */
@Repository
public interface ProductCategoryRepostory extends JpaRepository<ProductCategory, Integer> {
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
    List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
}

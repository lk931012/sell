package com.study.sell.repostory;

import com.study.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 23:03
 */
@Repository
public interface ProductInfoRepostroy extends JpaRepository<ProductInfo, String> {

    /**
     * 通过商品状态查询商品,主要分上架和下架.
     */
    List<ProductInfo> findByProductStatus(Integer integer);

    /**
     * 通过商品分类编号查询
     */
    List<ProductInfo> findByCategoryType(Integer integer);
}

package com.study.sell.service.impl;

import com.study.sell.entity.ProductCategory;
import com.study.sell.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 23:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryService service;

    @Test
    public void findByCategoryName() {
        ProductCategory productCategory = service.findByCategoryName("小吃1");
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findByCategoryType() {
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<ProductCategory> categoryList = service.findByCategoryTypes(list);
        System.out.print(categoryList.get(1).toString());
    }
}
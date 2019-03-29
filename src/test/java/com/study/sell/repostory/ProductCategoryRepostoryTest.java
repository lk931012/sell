package com.study.sell.repostory;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.study.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Auther : 冷科
 * @Date : 2019/3/9 15:47
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepostoryTest {
    @Autowired
    private ProductCategoryRepostory repostory;

    @Test
    public void testProduct() {
        ProductCategory category = repostory.findById(4).get();
        Assert.assertNotNull(category);

    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("新产品");
        productCategory.setCategoryType(15);
        repostory.save(productCategory);
    }

    @Test
    public void update() {
        ProductCategory productCategory = repostory.findById(4).get();
        productCategory.setCategoryName("鸡肉2");
        repostory.save(productCategory);
    }
}
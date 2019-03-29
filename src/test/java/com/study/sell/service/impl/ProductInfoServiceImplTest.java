package com.study.sell.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.study.sell.entity.ProductInfo;
import com.study.sell.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 00:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService service;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = service.findUpAll();
        System.out.print(productInfoList.get(0).toString());
    }

    @Test
    public void findByCategotyType() {
        List<ProductInfo> productInfoList = service.findByCategotyType(1);
        System.out.print(productInfoList.get(0).toString());
    }

    @Test
    public void save() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 5);
        Page<ProductInfo> page = service.findAll(pageRequest);
        System.out.print(page.getTotalElements());
    }
}
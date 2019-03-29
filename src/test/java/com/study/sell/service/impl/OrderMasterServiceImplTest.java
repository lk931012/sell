package com.study.sell.service.impl;

import com.study.sell.entity.OrderMaster;
import com.study.sell.repostory.OrderMasterRepostory;
import com.study.sell.service.OrderMasterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 15:44
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterServiceImplTest {

    @Autowired
    private OrderMasterService service;

    @Test
    public void save() {

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("111");
        orderMaster.setBuyerName("订单10号");
        orderMaster.setBuyerAddress("成都市天堂区");
        orderMaster.setBuyerPhone("110");
        orderMaster.setOrderAmount(new BigDecimal(100));
        orderMaster.setBuyerOpenid("xxx");
        service.save(orderMaster);
    }

    @Test
    public void delete() {

        service.delete("1524517413473256163");
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<OrderMaster> orderMasterPage = service.findAll(pageRequest, "lk931012");
        for (OrderMaster orderMaster : orderMasterPage.getContent()) {
            System.out.println(orderMaster);
        }
    }

    @Test
    public void findById() {
        OrderMaster orderMaster = service.findById("1524484896897411341");
        System.out.print(orderMaster);
    }
}
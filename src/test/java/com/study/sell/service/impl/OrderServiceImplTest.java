package com.study.sell.service.impl;

import com.study.sell.dto.OrderDTO;
import com.study.sell.entity.OrderDetail;
import com.study.sell.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 23:39
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void save() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("冷科");
        orderDTO.setBuyerPhone("18300001111");
        orderDTO.setBuyerAddress("成都市天堂区");
        orderDTO.setBuyerOpenid("lk931012");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("3");
        orderDetail1.setProductQuantity(2);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("1");
        orderDetail2.setProductQuantity(1);
        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);
        orderDTO.setOrderDetailList(orderDetailList);
        orderService.save(orderDTO);
    }

    @Test
    public void delete() {
        orderService.delete("1552234355857162");
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<OrderDTO> orderDTOPage = orderService.findAll(pageRequest, "lk931012");
        for (OrderDTO orderDTO : orderDTOPage.getContent()) {
            System.out.println(orderDTO);
        }
    }


    @Test
    public void orderPay() {
        orderService.orderPay("1552238283973761");
    }
}
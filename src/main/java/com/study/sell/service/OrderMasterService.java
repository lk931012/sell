package com.study.sell.service;

import com.study.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 订单主表Service
 *
 * @Auther : 冷科
 * @Date : 2019/3/10 15:20
 */
public interface OrderMasterService {

    /**
     * 新增一个订单
     */
    void save(OrderMaster orderMaster);

    /**
     * 通过订单id删除一个订单
     */
    void delete(String id);

    /**
     * 根据买家名称查询所有订单
     */
    Page<OrderMaster> findAll(Pageable pageable, String buyerOpenid);

    /**
     * 更具订单id查询一个订单
     */
    OrderMaster findById(String id);

    /**
     * 支付订单：更改订单状态与支付状态
     */
    void orderPay(String orderId);

}

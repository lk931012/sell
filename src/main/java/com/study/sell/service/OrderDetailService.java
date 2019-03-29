package com.study.sell.service;

import com.study.sell.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 20:17
 */
public interface OrderDetailService {

    /**
     * 通过id查询一个订单详情
     */
    OrderDetail findById(String id);

    /**
     * 通过订单id,查询订单下所有订单详情
     */
    Page<OrderDetail> findAllByOrderId(Pageable pageable, String orderId);

    /**
     * 新增一个订单详情
     */
    void save(OrderDetail orderDetail);

    /**
     * 通过订单详情ID，删除一个订单详情
     */
    void delete(String id);

}

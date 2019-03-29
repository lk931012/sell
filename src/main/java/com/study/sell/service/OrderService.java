package com.study.sell.service;

import com.study.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 22:14
 */
public interface OrderService {
    /**
     * 新增一个订单
     */
    OrderDTO save(OrderDTO orderDTO);

    /**
     * 通过订单id删除一个订单
     */
    void delete(String id);

    /**
     * 分页查询所有订单,不需要查询详情
     */
    Page<OrderDTO> findAll(Pageable pageable);

    /**
     * 根据微信号分页查询所有订单,不需要查询详情
     */
    Page<OrderDTO> findAll(Pageable pageable, String buyerOpenid);

    /**
     * 更具订单id查询一个订单
     */
    OrderDTO detail(String orderId);

    /**
     * 更具订单id和微信号查询一个订单
     */
    OrderDTO detail(String orderId, String openid);

    /**
     * 支付订单：更改订单状态与支付状态
     */
    void orderPay(String orderId);

    /**
     * 完结订单：需要订单状态为新增状态
     */
    void finish(String orderId);

    /**
     * 管理员取消订单
     */
    void cancel(String orderId);

    /**
     * 用户取消订单
     */
    void cancel(String openid, String orderId);
}

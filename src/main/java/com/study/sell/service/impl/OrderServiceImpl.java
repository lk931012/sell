package com.study.sell.service.impl;

import com.study.sell.common.enums.ExceptionEnum;
import com.study.sell.common.enums.OrderPaymentStatusEnum;
import com.study.sell.common.enums.OrderStatusEnum;
import com.study.sell.common.exception.SellException;
import com.study.sell.common.utils.RandomID;
import com.study.sell.dto.OrderDTO;
import com.study.sell.entity.OrderDetail;
import com.study.sell.entity.OrderMaster;
import com.study.sell.entity.ProductInfo;
import com.study.sell.repostory.OrderDetailRepostory;
import com.study.sell.repostory.OrderMasterRepostory;
import com.study.sell.service.OrderService;
import com.study.sell.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 22:18
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderMasterRepostory orderMasterRepostory;

    @Autowired
    private OrderDetailRepostory orderDetailRepostory;

    @Override
    @Transactional
    public OrderDTO save(OrderDTO orderDTO) {
        String orderId = RandomID.getID();
        //整个订单的总价,由订单详情计算
        BigDecimal amount = new BigDecimal(0);
        //遍历添加订单详情
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            //计算单个订单详情的总价
            ProductInfo productInfo = productInfoService.findById(orderDetail.getProductId());
            amount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(amount);
            //前端只传递了产品的id和数量,还需要给其他属性赋值.
            orderDetail.setDetailId(RandomID.getID());
            orderDetail.setOrderId(orderId);
            orderDetail.setProductName(productInfo.getProductName());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetailRepostory.save(orderDetail);
            //订单一旦创建成功就需要扣库存了
            productInfo.setProductStock(productInfo.getProductStock() - orderDetail.getProductQuantity());
            productInfoService.save(productInfo);
        }
        //创建订单对象,赋值并保存
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(amount);
        orderMaster.setBuyerName(orderDTO.getBuyerName());
        orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
        orderMaster.setBuyerOpenid(orderDTO.getBuyerOpenid());
        orderMaster.setBuyerAddress(orderDTO.getBuyerAddress());
        orderMasterRepostory.save(orderMaster);
        orderDTO.setOrderId(orderId);
        return orderDTO;
    }

    @Override
    public void delete(String id) {
        //库存增加
        OrderMaster orderMaster = orderMasterRepostory.findById(id).get();
        List<OrderDetail> orderDetailList = orderDetailRepostory.findAllByOrderId(orderMaster.getOrderId());
        for (OrderDetail orderDetail : orderDetailList) {
            ProductInfo productInfo = productInfoService.findById(orderDetail.getProductId());
            productInfo.setProductStock(productInfo.getProductStock() + orderDetail.getProductQuantity());
            productInfoService.save(productInfo);
        }
        //删除订单
        orderMasterRepostory.deleteById(id);
    }

    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepostory.findAll(pageable);
        //遍历组装OrderDTO
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasterPage.getContent()) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(orderMaster, orderDTO);
            orderDTOList.add(orderDTO);
        }
        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
        return orderDTOPage;
    }

    @Override
    public Page<OrderDTO> findAll(Pageable pageable, String buyerOpenid) {
        Page<OrderMaster> orderMasterPage = orderMasterRepostory.findAllByBuyerOpenid(pageable, buyerOpenid);

        //遍历组装OrderDTO
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderMaster orderMaster : orderMasterPage.getContent()) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(orderMaster, orderDTO);
            orderDTOList.add(orderDTO);
        }
        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
        return orderDTOPage;
    }

    @Override
    public OrderDTO detail(String orderId) {
        OrderDTO orderDTO = new OrderDTO();
        OrderMaster orderMaster = orderMasterRepostory.findById(orderId).get();
        List<OrderDetail> orderDetailList = orderDetailRepostory.findAllByOrderId(orderId);
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public OrderDTO detail(String orderId, String openid) {
        OrderDTO orderDTO = new OrderDTO();
        //判断买家是否存在此订单
        Boolean exist = false;
        List<OrderMaster> orderMasterList = orderMasterRepostory.findAllByBuyerOpenid(openid);
        for (OrderMaster orderMaster : orderMasterList) {
            //如果存在则继续下一步
            if (orderMaster.getOrderId().equals(orderId)) {
                List<OrderDetail> orderDetailList = orderDetailRepostory.findAllByOrderId(orderMaster.getOrderId());
                BeanUtils.copyProperties(orderMaster, orderDTO);
                orderDTO.setOrderDetailList(orderDetailList);
                exist = true;
            }
        }
        //不存在则抛出异常
        if (exist == false) {
            throw new SellException(ExceptionEnum.PARAM_EXCEPTION.getMsg());
        }
        return orderDTO;
    }

    @Override
    public void orderPay(String orderId) {
        OrderMaster orderMaster = orderMasterRepostory.findById(orderId).get();
        //判断是否存在
        if (orderMaster == null) {
            throw new SellException(ExceptionEnum.NULL_ORDER.getMsg());
        }
        //判断支付状态是否已支付
        if (orderMaster.getPaymentStatus().equals(OrderStatusEnum.FINISH.getCode())) {
            throw new SellException(ExceptionEnum.ORDER_STATUS_ERROR.getMsg());
        }
        //修改支付状态
        orderMaster.setPaymentStatus(OrderPaymentStatusEnum.PAID.getCode());
        orderMasterRepostory.save(orderMaster);
    }

    @Override
    public void finish(String orderId) {
        //判断是否是新订单
        OrderMaster orderMaster = orderMasterRepostory.findById(orderId).get();
        if (orderMaster.getOrderStatus() != OrderStatusEnum.NEW.getCode()) {
            throw new SellException(ExceptionEnum.ORDER_STATUS_ERROR.getMsg());
        }
        //修改订单状态并保存
        orderMaster.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        orderMasterRepostory.save(orderMaster);
    }

    @Override
    public void cancel(String orderId) {
        OrderMaster orderMaster = orderMasterRepostory.findById(orderId).get();
        //判断订单状态
        if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new SellException(ExceptionEnum.ORDER_STATUS_ERROR.getMsg());
        }
        //修改订单状态
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        orderMasterRepostory.save(orderMaster);
        //修改库存
        List<OrderDetail> orderDetailList = orderDetailRepostory.findAllByOrderId(orderMaster.getOrderId());
        for (OrderDetail orderDetail : orderDetailList) {
            ProductInfo productInfo = productInfoService.findById(orderDetail.getProductId());
            productInfo.setProductStock(productInfo.getProductStock() + orderDetail.getProductQuantity());
            productInfoService.save(productInfo);
        }
    }

    @Override
    public void cancel(String openid, String orderId) {
        Boolean exist = false;
        List<OrderMaster> orderMasterList = orderMasterRepostory.findAllByBuyerOpenid(openid);
        for (OrderMaster orderMaster : orderMasterList) {
            //判断买家是否存在此订单
            if (orderMaster.getOrderId().equals(orderId)) {
                //判断订单状态
                if (!orderMaster.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
                    throw new SellException(ExceptionEnum.ORDER_STATUS_ERROR.getMsg());
                }
                //修改订单状态
                orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
                orderMasterRepostory.save(orderMaster);
                //修改库存
                List<OrderDetail> orderDetailList = orderDetailRepostory.findAllByOrderId(orderMaster.getOrderId());
                for (OrderDetail orderDetail : orderDetailList) {
                    ProductInfo productInfo = productInfoService.findById(orderDetail.getProductId());
                    productInfo.setProductStock(productInfo.getProductStock() + orderDetail.getProductQuantity());
                    productInfoService.save(productInfo);
                }
                exist = true;
            }
        }
        //不存在则抛出异常
        if (exist == false) {
            throw new SellException(ExceptionEnum.PARAM_EXCEPTION.getMsg());
        }
    }
}

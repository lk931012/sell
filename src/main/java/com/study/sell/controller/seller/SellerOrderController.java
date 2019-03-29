package com.study.sell.controller.seller;

import com.study.sell.dto.OrderDTO;
import com.study.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 卖家订单Controller
 *
 * @Auther : 冷科
 * @Date : 2019/3/13 08:31
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 订单列表
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1", required = true) Integer page,
                             @RequestParam(value = "size", defaultValue = "10", required = true) Integer size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findAll(pageRequest);
        ModelAndView modelAndView = new ModelAndView("seller/order_list");
        modelAndView.addObject("orderDTOPage", orderDTOPage);
        modelAndView.addObject("currentPage", page);
        return modelAndView;
    }

    /**
     * 订单详情
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(value = "orderId") String orderId) {
        OrderDTO orderDTO = orderService.detail(orderId);
        return new ModelAndView("seller/order_detail", "orderDTO", orderDTO);
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "orderId") String orderId) {
        orderService.cancel(orderId);
        return list(1, 10);
    }

    /**
     * 完结订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam(value = "orderId") String orderId) {
        orderService.finish(orderId);
        return list(1, 10);
    }
}

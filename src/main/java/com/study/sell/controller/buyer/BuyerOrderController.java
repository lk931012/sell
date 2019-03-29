package com.study.sell.controller.buyer;

import com.study.sell.common.enums.BaseResultVOEnum;
import com.study.sell.common.exception.SellException;
import com.study.sell.common.utils.JsonConvert;
import com.study.sell.dto.OrderDTO;
import com.study.sell.form.OrderForm;
import com.study.sell.service.OrderService;
import com.study.sell.vo.BaseResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买家订单Controller
 *
 * @Auther : 冷科
 * @Date : 2019/3/11 02:47
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * 请求参数：
     * name:二郎神
     * phone:13222222222
     * address:南天门
     * openid:els666
     * items:[{productId:"1553436221753777",productQuantity:2}]
     * @param orderForm     接收前台传递的数据
     * @param bindingResult 表单验证结果
     * @return
     */
    @PostMapping("/create")
    public BaseResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        //判断表单是否有误
        if (bindingResult.hasErrors()) {
            //抛出异常 提示具体错误.
            throw new SellException(bindingResult.getFieldError().getDefaultMessage());
        }
        //将orderForm转换为OrderDTO.
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setOrderDetailList(JsonConvert.jsonToList(orderForm.getItems()));

        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderService.save(orderDTO).getOrderId());
        return BaseResultVO.success(BaseResultVOEnum.SUCCESS.getMsg(), map);
    }

    /**
     * 订单列表
     *
     * @param openid 微信号
     * @param page   第几页面
     * @param size   每页大小
     * @return
     */
    @PostMapping("/list")
    public BaseResultVO<List<OrderDTO>> list(@RequestParam(value = "openid", required = true) String openid,
                                             @RequestParam(value = "page", defaultValue = "0", required = true) Integer page,
                                             @RequestParam(value = "size", defaultValue = "5", required = true) Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findAll(pageRequest, openid);
        return BaseResultVO.success(orderDTOPage.getContent());
    }


    /**
     * 订单详情
     *
     * @param openid  微信号
     * @param orderId 订单id
     * @return
     */
    @PostMapping("/detail")
    public BaseResultVO<OrderDTO> detail(@RequestParam(value = "openid", required = true) String openid,
                                         @RequestParam(value = "orderId", required = true) String orderId) {
        return BaseResultVO.success(orderService.detail(orderId, openid));
    }


    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping("/cancel")
    public BaseResultVO<OrderDTO> cancel(@RequestParam(value = "openid", required = true) String openid,
                                         @RequestParam(value = "orderId", required = true) String orderId) {
        orderService.cancel(openid, orderId);
        return BaseResultVO.success();
    }
}

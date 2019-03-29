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
 * 卖家管理主界面Controller
 *
 * @Auther : 冷科
 * @Date : 2019/3/13 08:31
 */
@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerIndexController {

    @RequestMapping("/index")
    public String index() {
        return "seller/index";
    }

    @RequestMapping("")
    public String index2() {
        return "seller/index";
    }
}

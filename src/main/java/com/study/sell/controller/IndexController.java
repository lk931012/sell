package com.study.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther : 冷科
 * @Date : 2019/3/18 09:44
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "login";
    }
}

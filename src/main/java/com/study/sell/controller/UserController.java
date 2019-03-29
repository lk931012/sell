package com.study.sell.controller;

import com.study.sell.common.exception.LoginException;
import com.study.sell.form.UserForm;
import com.study.sell.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Auther : 冷科
 * @Date : 2019/3/18 09:30
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(@Valid UserForm userForm, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            return new ModelAndView("login", "msg", msg);

        }
        Boolean result = userService.login(userForm.getUserName(), userForm.getPassword(), response);
        if (result == false) {
            return new ModelAndView("login", "msg", "用户名或者密码错误!");
        }
        return new ModelAndView("seller/index");
    }

    /**
     * 用户登出
     *
     * @return
     */
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request) {
        userService.logout(response, request);
        return new ModelAndView("login");
    }
}

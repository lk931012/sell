package com.study.sell.common.handler;

import com.study.sell.common.exception.UserAutoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther : 冷科
 * @Date : 2019/3/18 13:34
 */
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserAutoException.class)
    public ModelAndView userAuthExceptionHandler() {
        //return new ModelAndView("login");
        return new ModelAndView("redirect:/index");
    }
}

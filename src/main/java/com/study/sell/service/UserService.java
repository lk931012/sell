package com.study.sell.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther : 冷科
 * @Date : 2019/3/18 08:49
 */
public interface UserService {

    /**
     * 用户登录
     */
    public Boolean login(String userName, String password, HttpServletResponse response);

    /**
     * 用户注销
     */
    public void logout(HttpServletResponse response, HttpServletRequest request);
}

package com.study.sell.service.impl;

import com.study.sell.common.constant.CookieConstant;
import com.study.sell.entity.User;
import com.study.sell.repostory.UserRespostory;
import com.study.sell.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther : 冷科
 * @Date : 2019/3/18 08:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRespostory userRespostory;

    @Autowired
    private StringRedisTemplate redis;

    @Override
    public Boolean login(String userName, String password, HttpServletResponse response) {
        Boolean b = false;
        if (userName != null && password != null) {
            User user = userRespostory.findByUserName(userName);
            if (user != null) {
                //用户登录成功
                if (user.getUserPassword().equals(password)) {
                    //1.在cookie里面做标记.
                    Cookie cookie = new Cookie(CookieConstant.TOKEN, "用户登录标记!");
                    cookie.setPath("/");
                    cookie.setMaxAge(CookieConstant.EXPIRATION_TIME);//设置过期时间2个小时
                    response.addCookie(cookie);
                    //2.将用户添加到redis
                    redis.opsForValue().set(CookieConstant.TOKEN, "用户登录标记!", CookieConstant.EXPIRATION_TIME);
                    b = true;
                }
            }

        }
        return b;
    }

    @Override
    public void logout(HttpServletResponse response, HttpServletRequest request) {
        //判断是否登录(检测cookie是否有token)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(CookieConstant.TOKEN)) {
                    //删除cookie
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    //删除redis
                    redis.opsForValue().getOperations().delete(CookieConstant.TOKEN);
                }
            }
        }
    }
}

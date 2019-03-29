package com.study.sell.common.aop;

import com.study.sell.common.constant.CookieConstant;
import com.study.sell.common.exception.LoginException;
import com.study.sell.common.exception.UserAutoException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录验证切面
 *
 * @Auther : 冷科
 * @Date : 2019/3/18 12:57
 */
@Aspect
@Component
@Slf4j
public class UserAuthAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //切面,seller包下面的所有方法都进行验证
    @Pointcut("execution(public * com.study.sell.controller.seller.*.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            log.info("Cookie中没有token");
            throw new UserAutoException("Cookie中没有token");
        }
        for (Cookie cookie : cookies) {
            //如果cookie里面有token,再去redis里面查询.
            if (cookie.getName().equals(CookieConstant.TOKEN)) {
                String token = redisTemplate.opsForValue().get(CookieConstant.TOKEN);
                if (token == null) {
                    log.info("redis中没有token.");
                    throw new UserAutoException("redis中没有token.");
                }
            }
        }
    }
}

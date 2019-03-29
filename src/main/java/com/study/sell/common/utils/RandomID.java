package com.study.sell.common.utils;

import java.util.Random;

/**
 * 生成随机id
 *
 * @Auther : 冷科
 * @Date : 2019/3/10 22:51
 */
public class RandomID {

    public static String getID() {
        Random random = new Random();
        Integer num = random.nextInt(1000);
        return System.currentTimeMillis() + String.valueOf(num);
    }
}

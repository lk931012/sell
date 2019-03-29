package com.study.sell.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.sell.entity.OrderDetail;

import java.util.List;

/**
 * json格式转换
 *
 * @Auther : 冷科
 * @Date : 2019/3/11 03:20
 */
public class JsonConvert {

    /**
     * json转换成list
     */
    public static List<OrderDetail> jsonToList(String json) {
        Gson gson = new Gson();
        // String str = gson.toJson(list);//list转json
        return gson.fromJson(json, new TypeToken<List<OrderDetail>>() {
        }.getType());
    }
}

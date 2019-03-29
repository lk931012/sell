package com.study.sell.common.config;

import lombok.Data;

/**
 * 用户基本信息
 *
 * @Auther : 冷科
 * @Date : 2019/3/13 06:33
 */
@Data
public class WechatUserInfo {
    private String openid;   //微信号
    private String nickname; //昵称
    private Integer sex;      //性别
    private String country;  //国家
    private String language; //语言
    private String city;     //城市

}

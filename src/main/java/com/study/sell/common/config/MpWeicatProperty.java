package com.study.sell.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 接收yml配置文件中 weicat 的属性
 *
 * @Auther : 冷科
 * @Date : 2019/3/13 04:56
 */
@Data
@Component
@ConfigurationProperties(prefix = "weicat")
public class MpWeicatProperty {
    private String mpAppID;           //appID
    private String mpSecret;          //appsecret
}

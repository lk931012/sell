package com.study.sell.common.config;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 微信配置
 *
 * @Auther : 冷科
 * @Date : 2019/3/13 06:08
 */
@Component
public class MpWeicatConfig {
    @Autowired
    private MpWeicatProperty mpWeicatProperty;

    @Bean
    public WxMpService WxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(mpWeicatProperty.getMpAppID());
        wxMpInMemoryConfigStorage.setSecret(mpWeicatProperty.getMpSecret());
        wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
        return wxMpService;
    }
}

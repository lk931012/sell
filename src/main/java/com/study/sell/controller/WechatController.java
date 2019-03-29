package com.study.sell.controller;

import com.study.sell.common.config.MpWeicatConfig;
import com.study.sell.common.config.WechatUserInfo;
import com.study.sell.common.enums.ExceptionEnum;
import com.study.sell.common.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 微信Controller
 *
 * @Auther : 冷科
 * @Date : 2019/3/12 17:36
 */
@Controller
@Slf4j
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private MpWeicatConfig mpWeicatConfig;

    /**
     * 用户授权
     * 8 用户点击下面链接进行授权认证
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxeeed55c6f44f1218&redirect_uri=http://lengke1.natapp1.cc/wechat/authorize&response_type=code&scope=snsapi_userinfo&state=http://lengke1.natapp1.cc/product/list/#wechat_redirect;
     * 同意授权后获取到code, 再用code获取access_token.
     * https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxeeed55c6f44f1218&secret=3f9a36a5a4162fb885fa74e44565eaf3&code="+code+"&grant_type=authorization_code;
     * 通过code获取用户信息
     * https://api.weixin.qq.com/sns/userinfo?access_token=19_yyKVtgYaBjgvCxscMXqH3FKqcnbYzuEW_9KOuD4vy7T7uz9hVCSjHwc3bVhHuUlxKwmEd5fmWcZI1FgyogT37-HBwD93mf_r8LvBxbnmHPA&openid=o5W-t5m4R1gCrIgCwkENqgwohUDs&lang=zh_CN
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam(value = "returnUrl", required = false) String returnUrl) {
        //用户授权完成后的重定向链接,用于获取code,redirect_uri/?code=CODE&state=STATE
        String redirectUrl = "http://lengke1.natapp1.cc/wechat/getAccess_token";
        //构建用户授权URL
        String authUrl = mpWeicatConfig.WxMpService().oauth2buildAuthorizationUrl(redirectUrl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, returnUrl);
        return "redirect:" + authUrl;
    }

    /**
     * 通过code获取access_token
     *
     * @param code  code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期.
     * @param state 重定向后会带上state参数,可以填写a-zA-Z0-9的参数值，最多128字节
     * @return
     */
    @GetMapping("/getAccess_token")
    public String getAccess_token(@RequestParam(value = "code") String code,
                                  @RequestParam(value = "state") String state) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = mpWeicatConfig.WxMpService().oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            throw new SellException(ExceptionEnum.WX_GET_ACCESS_TOKEN_EXCEPTION.getMsg());
        }
        WxMpUser wxMpUser = new WxMpUser();
        try {
            wxMpUser = mpWeicatConfig.WxMpService().oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            throw new SellException(ExceptionEnum.WX_GET_USER_INFO_EXCEPTION.getMsg());
        }
        /*WechatUserInfo wechatUserInfo = new WechatUserInfo();
        wechatUserInfo.setOpenid(wxMpUser.getOpenId());
        wechatUserInfo.setNickname(wxMpUser.getNickname());
        wechatUserInfo.setSex(wxMpUser.getSex());
        wechatUserInfo.setCountry(wxMpUser.getCountry());
        wechatUserInfo.setLanguage(wxMpUser.getLanguage());
        wechatUserInfo.setCity(wxMpUser.getCity());
        System.out.println(wechatUserInfo);*/
        return "redirect:" + state + "?openid=" + wxMpUser.getOpenId();
    }


}

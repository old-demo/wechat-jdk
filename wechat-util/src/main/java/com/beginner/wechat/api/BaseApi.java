package com.beginner.wechat.api;

/**
 * 微信公共接口地址
 * @author heqing
 * @date 2018/5/14
 */
public class BaseApi {

    /**
     * 微信服务域名地址
     */
    protected final static String WEIXIN = "https://api.weixin.qq.com/cgi-bin";

    /**
     * 获取微信TOKEN
     */
    public final static String TOKEN_GET = WEIXIN + "/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

}

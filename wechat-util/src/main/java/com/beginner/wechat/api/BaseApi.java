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
    public final static String GET_TOKEN = WEIXIN + "/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 获取微信服务器IP地址
     */
    public final static String GET_CALLBACK_IP = WEIXIN + "/getcallbackip?access_token=ACCESS_TOKEN";
}

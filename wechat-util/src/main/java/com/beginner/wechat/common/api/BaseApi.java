package com.beginner.wechat.common.api;

/**
 * 微信接口地址
 *
 * @author heqing
 * @date 2018/5/14
 */
public class BaseApi {

    public final static String WEIXIN = "https://api.weixin.qq.com/cgi-bin";
    /**
     * GET_TOKEN 获取access_token
     */
    public final static String GET_TOKEN = WEIXIN + "/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * GET_CALLBACK_IP 获取微信服务器IP地址
     */
    public final static String GET_CALLBACK_IP = WEIXIN + "/getcallbackip?access_token=ACCESS_TOKEN";
}

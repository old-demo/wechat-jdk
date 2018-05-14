package com.beginner.wechat.constant;

/**
 * 微信接口地址
 *
 * @author heqing
 * @date 2018/5/14
 */
public class BaseApi {

    public final static String WEIXIN = "https://api.weixin.qq.com";
    /**
     * GET_TOKEN 获取access_token
     */
    public final static String GET_TOKEN = WEIXIN + "/cgi-bin/token";
    /**
     * GET_CALLBACK_IP 获取微信服务器IP地址
     */
    public final static String GET_CALLBACK_IP = WEIXIN + "/cgi-bin/getcallbackip";
}

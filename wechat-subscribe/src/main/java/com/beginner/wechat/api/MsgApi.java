package com.beginner.wechat.api;

/**
 * 消息管理
 * @author heqing
 * @date 2018/6/3.
 */
public class MsgApi extends BaseApi {

    /**
     * SUBSCRIBE_TEMPLATE 推送一次性订阅消息
     */
    public final static String SUBSCRIBE_TEMPLATE = WEIXIN + "/message/template/subscribe?access_token=ACCESS_TOKEN";

    /**
     * CLEAR_QUOTA 推送一次性订阅消息
     */
    public final static String CLEAR_QUOTA = WEIXIN + "/clear_quota?access_token=ACCESS_TOKEN";

    /**
     * GET_AUTO_REPLY_INFO 获取公众号的自动回复规则
     */
    public final static String GET_AUTO_REPLY_INFO = WEIXIN + "/get_current_autoreply_info?access_token=ACCESS_TOKEN";
}

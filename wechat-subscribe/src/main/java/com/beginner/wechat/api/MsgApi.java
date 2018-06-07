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

    /**
     * SEND_MASS_ALL_BY_TAG 根据标签进行群发【订阅号与服务号认证后均可用】
     */
    public final static String SEND_MASS_ALL_BY_TAG = WEIXIN + "/message/mass/sendall?access_token=ACCESS_TOKEN";


    /**
     * SEND_MASS_ALL_BY_OPENID 根据标签进行群发【订阅号与服务号认证后均可用】
     */
    public final static String SEND_MASS_ALL_BY_OPENID = WEIXIN + "/message/mass/send?access_token=ACCESS_TOKEN";

    /**
     * PREVIEW_MASS 预览接口【订阅号与服务号认证后均可用】
     */
    public final static String PREVIEW_MASS = WEIXIN + "/message/mass/preview?access_token=ACCESS_TOKEN";

    /**
     * DELETE_MASS 删除群发【订阅号与服务号认证后均可用】
     */
    public final static String DELETE_MASS = WEIXIN + "/message/mass/delete?access_token=ACCESS_TOKEN";

    /**
     * GET_MASS 查询群发消息发送状态【订阅号与服务号认证后均可用】
     */
    public final static String GET_MASS = WEIXIN + "/message/mass/delete?access_token=ACCESS_TOKEN";

    /**
     * GET_MASS_SPEED 查询群发消息发送状态【订阅号与服务号认证后均可用】
     */
    public final static String GET_MASS_SPEED = WEIXIN + "/message/mass/speed/get?access_token=ACCESS_TOKEN";

    /**
     * SET_MASS_SPEED 查询群发消息发送状态【订阅号与服务号认证后均可用】
     */
    public final static String SET_MASS_SPEED = WEIXIN + "/message/mass/speed/set?access_token=ACCESS_TOKEN";
}

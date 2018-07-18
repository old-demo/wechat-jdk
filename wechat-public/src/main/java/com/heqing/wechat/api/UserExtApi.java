package com.heqing.wechat.api;

/**
 * 基本信息/黑名单 微信接口地址
 * @author heqing
 * @date 2018/5/29
 */
public class UserExtApi extends UserApi {

    /**
     * 获取用户基本信息
     */
    public final static String USER_GET_INFO = WEIXIN + "/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /**
     * 获取多个用户基本信息
     */
    public final static String USER_LIST_INFO = WEIXIN + "/user/info/batchget?access_token=ACCESS_TOKEN";

    /**
     * 获取公众号的黑名单列表
     */
    public final static String USER_GET_BLACK_FANS = WEIXIN + "/tags/members/getblacklist?access_token=ACCESS_TOKEN";

    /**
     * 拉黑用户
     */
    public final static String USER_SET_BLACK_FANS = WEIXIN + "/tags/members/batchblacklist?access_token=ACCESS_TOKEN";

    /**
     * 取消拉黑用户
     */
    public final static String USER_SET_UN_BLACK_FANS = WEIXIN + "/tags/members/batchblacklist?access_token=ACCESS_TOKEN";
}

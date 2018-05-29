package com.beginner.wechat.api;

import com.beginner.wechat.api.UserApi;

/**
 * @author heqing
 * @date 2018/5/29.
 */
public class UserExtApi extends UserApi {

    /**
     * GET_USER_INFO  获取用户基本信息
     */
    public final static String GET_USER_INFO = WEIXIN + "/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /**
     * LIST_USER_INFO  获取多个用户基本信息
     */
    public final static String LIST_USER_INFO = WEIXIN + "/user/info/batchget?access_token=ACCESS_TOKEN";

    /**
     * GET_BLACK_FANS  获取公众号的黑名单列表
     */
    public final static String GET_BLACK_FANS = WEIXIN + "/tags/members/getblacklist?access_token=ACCESS_TOKEN";

    /**
     * SET_BLACK_FANS  拉黑用户
     */
    public final static String SET_BLACK_FANS = WEIXIN + "/tags/members/batchblacklist?access_token=ACCESS_TOKEN";

    /**
     * SET_UN_BLACK_FANS  取消拉黑用户
     */
    public final static String SET_UN_BLACK_FANS = WEIXIN + "/tags/members/batchblacklist?access_token=ACCESS_TOKEN";
}

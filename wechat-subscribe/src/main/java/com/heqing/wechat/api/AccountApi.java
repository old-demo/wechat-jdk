package com.heqing.wechat.api;

/**
 * @author heqing
 * @date 2018/10/17 11:40
 */
public class AccountApi extends BaseApi {

    /**
     * 用户微信授权页面
     */
    public final static String ACCOUNT_AUTHORIZATION = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

    /**
     * 通过code换取网页授权access_token
     */
    public final static String GET_AUTHORIZATION_TIKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

}

package com.beginner.wechat.service;

import com.beginner.wechat.model.AccessToken;
import com.beginner.wechat.model.Result;

import java.util.List;

/**
 * 公共方法接口
 *
 * @author heqing
 * @date 2018/5/14
 */
public interface BaseService {

    /**
     * 获取微信access_token
     *
     * @param appid 第三方用户唯一凭证
     * @param secret 第三方用户唯一凭证密钥，即appsecret
     * @return 微信access_token
     */
    Result<AccessToken> getAccessToken(String appid, String secret);

    /**
     * 获取微信服务器IP地址
     *
     * @param accessToken 微信access_token
     * @return 服务器IP地址
     */
    Result<List<String>> listCallBackIP(String accessToken);
}

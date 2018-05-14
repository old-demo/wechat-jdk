package com.beginner.wechat.service.base;

import com.beginner.wechat.model.base.AccessToken;

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
     * @return
     */
    AccessToken getAccessToken(String appid, String secret);
}

package com.heqing.wechat.service;

import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.account.WebAccessToken;

/**
 * 账号管理 接口
 * @author heqing
 * @date 2018/6/5
 */
public interface AccountService {

    /**
     * 通过code换取网页授权access_token
     * @param appid 第三方用户唯一凭证
     * @param secret 第三方用户唯一凭证密钥，即appsecret
     * @param code 授权页获取的token
     * @return 网页授权access_token
     */
    Result<WebAccessToken> getWebAccessToken(String appid, String secret, String code);
}

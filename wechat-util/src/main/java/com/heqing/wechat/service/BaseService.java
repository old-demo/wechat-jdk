package com.heqing.wechat.service;

import com.heqing.wechat.model.AccessToken;
import com.heqing.wechat.model.Result;

/**
 * 微信公共方法接口
 * @author heqing
 * @date 2018/5/14
 */
public interface BaseService {

    /**
     * 获取微信TOKEN
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183">微信文档--获取access_token</a>
     * @param appid 第三方用户唯一凭证
     * @param secret 第三方用户唯一凭证密钥，即appsecret
     * @return 微信唯一凭证
     */
    Result<AccessToken> getAccessToken(String appid, String secret);

}

package com.beginner.wechat.service;

import com.beginner.wechat.model.AccessToken;
import com.beginner.wechat.model.Result;

import java.util.List;

/**
 * 微信公共方法接口
 * @author heqing
 * @date 2018/5/14
 */
public interface BaseService {

    /**
     * 获取微信TOKEN
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183">微信接口文档</a>
     * @param appid 第三方用户唯一凭证
     * @param secret 第三方用户唯一凭证密钥，即appsecret
     * @return 微信唯一凭证
     */
    Result<AccessToken> getAccessToken(String appid, String secret);

    /**
     * 获取微信服务器IP地址
     * @see <a href="http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140187">微信接口文档</a>
     * @param accessToken 微信access_token
     * @return 微信服务器IP地址列表
     */
    Result<List<String>> listCallBackIP(String accessToken);
}

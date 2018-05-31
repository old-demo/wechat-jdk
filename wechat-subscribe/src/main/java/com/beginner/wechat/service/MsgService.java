package com.beginner.wechat.service;

/**
 * 消息管理
 * @author heqing
 * @date 2018/5/31.
 */
public interface MsgService {

    /**
     * 校验signature判断是否接入成功
     *
     * @param accessToken 微信access_token
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @return
     */
    boolean checkSignature(String accessToken, String signature, String timestamp, String nonce);

}

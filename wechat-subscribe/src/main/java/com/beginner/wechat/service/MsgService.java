package com.beginner.wechat.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息管理
 * @author heqing
 * @date 2018/5/31.
 */
public interface MsgService {

    /**
     * 处理接收到的微信消息
     *
     * @param request 请求对象
     * @param response 返回对象
     * @param handlerMsgService 处理类
     * @param appid 开发者ID(AppID)
     * @param token 微信基本配置中的Token
     * @param encodingAesKey 微信基本配置中的消息加密密钥
     * @return
     */
    void handlerMsg(HttpServletRequest request, HttpServletResponse response, HandlerMsgService handlerMsgService,
                    String appid, String token, String encodingAesKey);

    /**
     * 校验signature判断是否接入成功
     *
     * @param token 微信基本配置中的Token
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param signature 微信加密签名
     * @return
     */
    boolean checkSignature(String token, String timestamp, String nonce, String signature);

    /**
     * 解析xml并进行相应处理
     *
     * @param xmlStr 接收的消息xml
     * @param handlerMsgService 处理类
     * @return
     */
    String analysisMsg(String xmlStr, HandlerMsgService handlerMsgService);

}

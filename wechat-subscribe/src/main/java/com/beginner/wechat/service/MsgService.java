package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.AutoReplyInfo;
import com.beginner.wechat.model.message.SendTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息管理
 * 多客服升级为新版客服，某些接口不再提服务，详见：
 *  https://mp.weixin.qq.com/cgi-bin/announce?action=getannouncement&key=1464266075&version=12&lang=zh_CN
 *
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

    /**
     * 一次性订阅消息
     *
     * @param accessToken 微信access_token
     * @param sendTemplate 模板消息
     * @return
     */
    Result subscribeTemplate(String accessToken, SendTemplate sendTemplate);

    /**
     * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零
     *
     * @param accessToken 微信access_token
     * @param appid 公众号的APPID
     * @return
     */
    Result clearQuota(String accessToken, String appid);

    /**
     * 获取公众号的自动回复规则
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result<AutoReplyInfo> getAutoReplyInfo(String accessToken);
}

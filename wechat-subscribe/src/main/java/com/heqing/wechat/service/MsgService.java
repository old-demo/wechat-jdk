package com.heqing.wechat.service;

import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.message.AutoReplyInfo;
import com.heqing.wechat.model.message.SendTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 消息管理 接口
 * @author heqing
 * @date 2018/5/31
 */
public interface MsgService {

    /**
     * 校验signature判断是否接入成功
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1434696670">微信文档--消息加解密说明</a>
     * @param token 微信基本配置中的Token
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param signature 微信加密签名
     * @return 是否接入成功
     */
    boolean checkSignature(String token, String timestamp, String nonce, String signature);

    /**
     * 处理接收到的微信消息
     * @param request 请求对象
     * @param response 返回对象
     * @param msgHandlerService 处理类
     * @param appid 开发者ID(AppID)
     * @param token 微信基本配置中的Token
     * @param encodingAesKey 微信基本配置中的消息加密密钥
     */
    void handlerMsg(HttpServletRequest request, HttpServletResponse response, MsgHandlerService msgHandlerService,
                    String appid, String token, String encodingAesKey);

    /**
     * 解析xml并进行相应处理
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1434696670">微信文档--消息加解密说明</a>
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140543">微信文档--被动回复用户消息</a>
     * @param xmlStr 接收的消息xml
     * @param msgHandlerService 处理类
     * @return
     */
    String analysisMsg(String xmlStr, MsgHandlerService msgHandlerService);

    /**
     * 获取微信服务器IP地址
     * @see <a href="http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140187">微信文档--获取微信服务器IP地址</a>
     * @param accessToken 微信access_token
     * @return 微信服务器IP地址列表
     */
    Result<List<String>> listCallBackIP(String accessToken);

    /**
     * 一次性订阅消息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1500374289_66bvB">微信文档--一次性订阅消息</a>
     * @param accessToken 微信access_token
     * @param sendTemplate 模板消息
     * @return 微信返回结果
     */
    Result subscribeTemplate(String accessToken, SendTemplate sendTemplate);

    /**
     * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433744592">微信文档--接口调用频次限制说明</a>
     * @param accessToken 微信access_token
     * @param appid 公众号的APPID
     * @return 微信返回结果
     */
    Result clearQuota(String accessToken, String appid);

    /**
     * 获取公众号的自动回复规则
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751299">微信文档--获取公众号的自动回复规则</a>
     * @param accessToken 微信access_token
     * @return 微信返回结果
     */
    Result<AutoReplyInfo> getAutoReplyInfo(String accessToken);

}

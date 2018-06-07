package com.beginner.wechat.service;

import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.AutoReplyInfo;
import com.beginner.wechat.model.message.SendTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据标签进行群发
     *
     * @param accessToken 微信access_token
     * @param isToAll （非必传）用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
     * @param tagId （非必传）群发到的标签的tag_id，参见用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
     * @param msgType 群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     * @param content 文本内容 或 其他类型文件的media_id
     * @param sendIgnoreReprint （图文时必传）图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
     * @return
     */
    Result sendMassAllByTag(String accessToken, boolean isToAll, int tagId, MsgType msgType, String content, int sendIgnoreReprint);

    /**
     * 根据OpenId进行群发
     *
     * @param accessToken 微信access_token
     * @param openIDList 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param msgType 群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     * @param content 文本内容 或 其他类型文件的media_id
     * @param sendIgnoreReprint （图文时必传）图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
     * @return
     */
    Result sendMassAllByOpenId(String accessToken, List<String> openIdList, MsgType msgType, String content, int sendIgnoreReprint);

    /**
     * 删除群发
     *
     * @param accessToken 微信access_token
     * @param msgId 发送出去的消息ID
     * @param articleIdx 要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
     * @return
     */
    Result deleteMass(String accessToken, Integer msgId, Integer articleIdx);

    /**
     * 预览接口【订阅号与服务号认证后均可用】
     *
     * @param accessToken 微信access_token
     * @param openId 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param msgType 群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
     * @param content 文本内容 或 其他类型文件的media_id
     * @param map 卡券 相关信息
     * @return
     */
    Result previewMass(String accessToken, String openId, MsgType msgType, String content, Map map);

    /**
     * 查询群发消息发送状态
     *
     * @param accessToken 微信access_token
     * @param msgId 发送出去的消息ID
     * @return
     */
    Result getMass(String accessToken, Integer msgId);

    /**
     * 获取群发速度
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result getMassSpeed(String accessToken);

    /**
     * 设置群发速度
     *
     * @param accessToken 微信access_token
     * @param speed 群发速度的级别 0:80w/分钟,1:60w/分钟,2:45w/分钟,3:30w/分钟,4:10w/分钟
     * @return
     */
    Result setMassSpeed(String accessToken, Integer speed);
}

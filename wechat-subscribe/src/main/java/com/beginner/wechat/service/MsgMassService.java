package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.BaseMsg;

import java.util.List;

/**
 * 群发接口和原创校验
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1481187827_i0l21">微信文档--群发接口和原创校验</a>
 * @author heqing
 * @date 2018/5/31
 */
public interface MsgMassService {

    /**
     * 根据标签进行群发
     * @param accessToken 微信access_token
     * @param isToAll （非必传）用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
     * @param tagId （非必传）群发到的标签的tag_id，参见用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
     * @param baseMsg 发送的消息
     * @param sendIgnoreReprint （图文时必传）图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
     * @param clientMsgId （非必传）开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid。
     * @return 微信返回结果<br/>
     *      msg_id:消息发送任务的ID
     *      msg_data_id:消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
     *          是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
     */
    Result sendMassAllByTag(String accessToken, boolean isToAll, int tagId, BaseMsg baseMsg, int sendIgnoreReprint, String clientMsgId);

    /**
     * 根据OpenId进行群发
     * @param accessToken 微信access_token
     * @param openIdList 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param baseMsg 发送的消息
     * @param sendIgnoreReprint （图文时必传）图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。
     * @param clientMsgId （非必传）开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid。
     * @return 微信返回结果<br/>
     *      msg_id:消息发送任务的ID
     *      msg_data_id:消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
     *          是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。
     */
    Result sendMassAllByOpenId(String accessToken, List<String> openIdList, BaseMsg baseMsg, int sendIgnoreReprint, String clientMsgId);

    /**
     * 删除群发
     * @param accessToken 微信access_token
     * @param msgId 发送出去的消息ID
     * @param articleIdx 要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
     * @return 微信返回结果
     */
    Result deleteMass(String accessToken, Integer msgId, Integer articleIdx);

    /**
     * 针对openID预览接口【订阅号与服务号认证后均可用】
     * @param accessToken 微信access_token
     * @param openId 填写图文消息的接收者，一串OpenID列表，OpenID最少2个，最多10000个
     * @param baseMsg 发送的消息
     * @return 微信返回结果
     */
    Result previewMassByOpenId(String accessToken, String openId, BaseMsg baseMsg);

    /**
     * 针对微信号预览接口【订阅号与服务号认证后均可用】
     * @param accessToken 微信access_token
     * @param wxName 微信号
     * @param baseMsg 发送的消息
     * @return 微信返回结果
     */
    Result previewMassByName(String accessToken, String wxName, BaseMsg baseMsg);

    /**
     * 查询群发消息发送状态
     * @param accessToken 微信access_token
     * @param msgId 发送出去的消息ID
     * @return 微信返回结果<br/>
     *      msg_id:群发消息后返回的消息id
     *      msg_status:消息发送后的状态，SEND_SUCCESS表示发送成功，SENDING表示发送中，SEND_FAIL表示发送失败，DELETE表示已删除
     */
    Result getMass(String accessToken, Integer msgId);

    /**
     * 获取群发速度
     * @param accessToken 微信access_token
     * @return 微信返回结果
     */
    Result getMassSpeed(String accessToken);

    /**
     * 设置群发速度
     * @param accessToken 微信access_token
     * @param speed 群发速度的级别 0:80w/分钟,1:60w/分钟,2:45w/分钟,3:30w/分钟,4:10w/分钟
     * @return 微信返回结果
     */
    Result setMassSpeed(String accessToken, Integer speed);
}

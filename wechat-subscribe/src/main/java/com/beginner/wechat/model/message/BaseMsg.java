package com.beginner.wechat.model.message;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.constant.EventType;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 基础消息结构
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453">微信文档--普通消息</a>
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454">微信文档--事件消息</a>
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseMsg {

    /**
     * 开发者微信号
     */
    @XmlElement(name = "ToUserName")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    protected String toUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    @XmlElement(name = "FromUserName")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    protected String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private Long createTime;

    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    protected Long msgId;

    /**
     * 消息发送后的状态，SEND_SUCCESS表示发送成功，SENDING表示发送中，SEND_FAIL表示发送失败，DELETE表示已删除
     */
    @JSONField(name = "msg_status")
    protected String msgStatus;

    /**
     * 消息类型，参见 com.beginner.wechat.constant.MsgType
     */
    @XmlElement(name = "MsgType")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    protected String msgType;

    /**
     * 事件类型，参见 com.beginner.wechat.constant.EventType
     */
    @XmlElement(name = "Event")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    protected String eventType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

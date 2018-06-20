package com.beginner.wechat.model.message;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.constant.EventType;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 基础消息结构
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseMsg {

    /**
     * toUserName 开发者微信号
     */
    @XmlElement(name = "ToUserName")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String toUserName;

    /**
     * fromUserName 发送方帐号（一个OpenID）
     */
    @XmlElement(name = "FromUserName")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String fromUserName;

    /**
     * createTime 	消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private Long createTime;

    /**
     * msgType 消息类型
     */
    @XmlElement(name = "MsgType")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String msgType;

    /**
     * msgId 消息id，64位整型
     */
    @XmlElement(name = "MsgId")
    private Long msgId;

    /**
     * event 事件，事件类型，参见EventType
     */
    @XmlElement(name = "Event")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String event;

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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType.getName();
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(EventType event) {
        this.event = event.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

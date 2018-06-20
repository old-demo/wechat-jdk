package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 发图的事件推送
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class PicPhotoEvent extends BaseMsg {

    /**
     * sendPicsInfo 发送的图片信息
     */
    @XmlElement(name = "SendPicsInfo")
    private SendPicsInfo sendPicsInfo;

    /**
     * eventKey 事件KEY值，由开发者在创建菜单时设定
     */
    @XmlElement(name = "EventKey")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String eventKey;

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

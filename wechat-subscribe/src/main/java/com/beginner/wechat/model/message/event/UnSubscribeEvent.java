package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.constant.EventType;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.message.BaseMsg;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 取消关注事件
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class UnSubscribeEvent extends BaseMsg {

    public UnSubscribeEvent() {
        this.msgType = MsgType.EVENT.getName();
        this.eventType = EventType.UN_SUBSCRIBE.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

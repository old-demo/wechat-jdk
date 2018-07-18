package com.heqing.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.constant.MsgType;
import com.heqing.wechat.model.message.BaseMsg;
import com.heqing.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 文本消息
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class TextMsg extends BaseMsg {

    /**
     * 文本消息内容
     */
    @XmlElement(name = "Content")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TextMsg() {
        this.msgType = MsgType.TEXT.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

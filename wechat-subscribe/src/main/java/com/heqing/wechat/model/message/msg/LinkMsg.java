package com.heqing.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.constant.MsgType;
import com.heqing.wechat.model.message.BaseMsg;
import com.heqing.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 链接消息
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class LinkMsg extends BaseMsg {

    /**
     * 消息标题
     */
    @XmlElement(name = "Title")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String title;

    /**
     * 消息描述
     */
    @XmlElement(name = "Description")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String description;

    /**
     * 消息链接
     */
    @XmlElement(name = "Url")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LinkMsg() {
        this.msgType = MsgType.LINK.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

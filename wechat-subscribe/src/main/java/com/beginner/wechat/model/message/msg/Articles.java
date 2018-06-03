package com.beginner.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.util.CDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 图文消息中的文章
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Articles {

    /**
     * title 图文消息标题
     */
    @XmlElement(name = "Title")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String title;

    /**
     * description 图文消息描述
     */
    @XmlElement(name = "Description")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String description;

    /**
     * picUrl 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    @XmlElement(name = "PicUrl")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String picUrl;

    /**
     * url 点击图文消息跳转链接
     */
    @XmlElement(name = "Url")
    @XmlJavaTypeAdapter(CDataAdapter.class)
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

package com.beginner.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 音乐消息
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class MusicMsg extends BaseMsg {

    /**
     * title 音乐标题 （非必传）
     */
    @XmlElement(name = "Title")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String title;

    /**
     * description 音乐描述（非必传）
     */
    @XmlElement(name = "Description")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String description;

    /**
     * musicURL 音乐链接（非必传）
     */
    @XmlElement(name = "MusicURL")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String musicURL;

    /**
     * hqMusicUrl 高质量音乐链接，WIFI环境优先使用该链接播放音乐（非必传）
     */
    @XmlElement(name = "HQMusicUrl")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String hqMusicUrl;

    /**
     * thumbMediaId 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XmlElement(name = "ThumbMediaId")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String thumbMediaId;

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

    public String getMusicURL() {
        return musicURL;
    }

    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

package com.beginner.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.constant.MsgType;
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
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class MusicMsg extends BaseMsg {

    /**
     * 音乐标题 （非必传）
     */
    @XmlElement(name = "Title")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String title;

    /**
     * 音乐描述（非必传）
     */
    @XmlElement(name = "Description")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String description;

    /**
     * 音乐链接（非必传）
     */
    @JSONField(name = "musicurl")
    @XmlElement(name = "MusicURL")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String musicURL;

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐（非必传）
     */
    @JSONField(name = "hqmusicurl")
    @XmlElement(name = "HQMusicUrl")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String hqMusicUrl;

    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    @JSONField(name = "thumb_media_id")
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

    public MusicMsg() {
        this.msgType = MsgType.MUSIC.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

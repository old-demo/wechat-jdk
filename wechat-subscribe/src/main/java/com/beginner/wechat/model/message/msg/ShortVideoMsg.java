package com.beginner.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.adapter.XmlDataAdapter;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.message.BaseMsg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 小视频消息
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ShortVideoMsg extends BaseMsg {

    /**
     * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @JSONField(name = "media_id")
    @XmlElement(name = "MediaId")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String mediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @JSONField(name = "thumb_media_id")
    @XmlElement(name = "ThumbMediaId")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String thumbMediaId;

    /**
     * 视频消息的标题 （回复才有此参数，非必传）
     */
    @XmlElement(name = "Title")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String title;

    /**
     * 视频消息的描述（回复才有此参数，非必传）
     */
    @XmlElement(name = "Description")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String description;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

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

    public ShortVideoMsg() {
        this.msgType = MsgType.SHORT_VIDEO.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

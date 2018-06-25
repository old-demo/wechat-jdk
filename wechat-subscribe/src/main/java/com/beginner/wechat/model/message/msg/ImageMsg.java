package com.beginner.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 图片消息
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ImageMsg extends BaseMsg {

    /**
     * 图片链接（由系统生成）
     */
    @XmlElement(name = "PicUrl")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String picUrl;

    /**
     * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @JSONField(name = "media_id")
    @XmlElement(name = "MediaId")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public ImageMsg() {
        this.msgType = MsgType.IMAGE.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

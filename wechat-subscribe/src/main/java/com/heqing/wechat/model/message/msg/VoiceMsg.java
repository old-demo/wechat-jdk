package com.heqing.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.heqing.wechat.constant.MsgType;
import com.heqing.wechat.model.message.BaseMsg;
import com.heqing.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 语音消息
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class VoiceMsg extends BaseMsg {

    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @JSONField(name = "media_id")
    @XmlElement(name = "MediaId")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String mediaId;

    /**
     * 语音格式，如amr，speex等
     */
    @XmlElement(name = "Format")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String format;

    /**
     * 语音识别结果，UTF8编码
     */
    @XmlElement(name = "Recognition")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String recognition;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public VoiceMsg() {
        this.msgType = MsgType.VOICE.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

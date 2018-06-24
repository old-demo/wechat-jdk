package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.constant.EventType;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.model.message.event.model.SendLocationInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 上报地理位置事件
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class LocationEvent extends BaseMsg {

    /**
     * 地理位置纬度
     */
    @XmlElement(name = "Latitude")
    private Double latitude;

    /**
     * 地理位置经度
     */
    @XmlElement(name = "Longitude")
    private Double longitude;

    /**
     * 地理位置精度
     */
    @XmlElement(name = "Precision")
    private Double precision;

    /**
     * 发送的位置信息
     */
    @XmlElement(name = "SendLocationInfo")
    private SendLocationInfo sendLocationInfo;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }

    public LocationEvent() {
        this.msgType = MsgType.EVENT.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

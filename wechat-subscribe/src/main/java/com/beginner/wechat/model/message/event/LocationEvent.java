package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.util.CDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 上报地理位置事件
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class LocationEvent extends BaseMsg {

    /**
     * event LOCATION
     */
    @XmlElement(name = "Event")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String event;

    /**
     * latitude 地理位置纬度
     */
    @XmlElement(name = "Latitude")
    private Double latitude;

    /**
     * longitude 地理位置经度
     */
    @XmlElement(name = "Longitude")
    private Double longitude;

    /**
     * precision 地理位置精度
     */
    @XmlElement(name = "Precision")
    private Double precision;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

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

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

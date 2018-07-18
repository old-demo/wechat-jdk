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
 * 地理位置消息
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class LocationMsg extends BaseMsg {

    /**
     * 地理位置维度
     */
    @XmlElement(name = "Location_X")
    private Double locationX;

    /**
     * 地理位置经度
     */
    @XmlElement(name = "Location_Y")
    private Double locationY;

    /**
     * 地图缩放大小
     */
    @XmlElement(name = "Scale")
    private Integer scale;

    /**
     * 地理位置信息
     */
    @XmlElement(name = "Label")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String label;

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocationMsg() {
        this.msgType = MsgType.LOCATION.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

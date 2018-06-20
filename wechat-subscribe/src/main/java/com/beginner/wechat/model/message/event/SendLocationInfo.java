package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 发送的位置信息
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SendLocationInfo {

    /**
     * locationX X坐标信息
     */
    @XmlElement(name = "Location_X")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String locationX;

    /**
     * locationY Y坐标信息
     */
    @XmlElement(name = "Location_Y")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String locationY;

    /**
     * scale 精度，可理解为精度或者比例尺、越精细的话 scale越高
     */
    @XmlElement(name = "Scale")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String scale;

    /**
     * label 地理位置的字符串信息
     */
    @XmlElement(name = "Label")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String label;

    /**
     * poiname 朋友圈POI的名字，可能为空
     */
    @XmlElement(name = "Poiname")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String poiname;

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPoiname() {
        return poiname;
    }

    public void setPoiname(String poiname) {
        this.poiname = poiname;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

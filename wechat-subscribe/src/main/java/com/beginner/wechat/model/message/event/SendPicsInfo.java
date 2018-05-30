package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * /**
 * 扫描信息
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SendPicsInfo {

    /**
     * count 发送的图片数量
     */
    @XmlElement(name = "Count")
    private Integer count;

    /**
     * picList 图片列表
     */
    @XmlElement(name = "PicList")
    private List<Pic> picList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Pic> getPicList() {
        return picList;
    }

    public void setPicList(List<Pic> picList) {
        this.picList = picList;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

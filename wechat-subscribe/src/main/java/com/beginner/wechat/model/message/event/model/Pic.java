package com.beginner.wechat.model.message.event.model;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 系统拍照发图, 结构有点坑
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Pic {

    /**
     * 图片的MD5值
     */
    @XmlElement(name = "PicMd5Sum")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String picMd5Sum;

    public String getPicMd5Sum() {
        return picMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum) {
        this.picMd5Sum = picMd5Sum;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

package com.beginner.wechat.model.message.event.model;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.model.message.BaseMsg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 认证事件
 * @author heqing
 * @date 2018/6/5
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class AuthenticationEvent extends BaseMsg {

    /**
     * 有效期 (整形)，指的是时间戳，将于该时间戳认证过期
     */
    @XmlElement(name = "ExpiredTime")
    private Long expiredTime;

    /**
     * 失败发生时间 (整形)，时间戳
     */
    @XmlElement(name = "FailTime")
    private Long failTime;

    /**
     * 失败原因
     */
    @XmlElement(name = "FailReason")
    private String failReason;

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Long getFailTime() {
        return failTime;
    }

    public void setFailTime(Long failTime) {
        this.failTime = failTime;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

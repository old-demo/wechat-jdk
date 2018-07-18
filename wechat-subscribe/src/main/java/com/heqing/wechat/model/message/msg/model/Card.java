package com.heqing.wechat.model.message.msg.model;

import com.alibaba.fastjson.JSONObject;

/**
 * 卡券
 * @author heqing
 * @date 2018/5/30
 */
public class Card {

    /**
     * 券码
     */
    private String code;

    /**
     * 普通用户openid
     */
    private String openid;

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 认证
     */
    private String signature;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

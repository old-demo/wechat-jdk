package com.beginner.wechat.model.account;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 二维码信息
 * @author heqing
 * @date 2018/6/5.
 */
public class QRCode {

    /**
     * ticket 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
     */
    private String ticket;

    /**
     * expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
     */
    @JSONField(name = "expire_seconds")
    private Integer expireSeconds;

    /**
     * url 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
     */
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

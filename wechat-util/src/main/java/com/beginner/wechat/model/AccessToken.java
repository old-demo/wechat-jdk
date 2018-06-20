package com.beginner.wechat.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取微信TOKEN返回对象
 * @author heqing
 * @date 2018/5/14
 */
public class AccessToken {

    /**
     * 获取到的凭证
     */
    @JSONField(name = "access_token")
    private String accessToken;
    
    /**
     * 凭证有效时间，单位：秒
     */
    @JSONField(name = "expires_in")
    private Integer expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

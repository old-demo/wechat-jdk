package com.beginner.wechat.model.base;

import com.alibaba.fastjson.JSONObject;

/**
 * accessToken
 *
 * @author heqing
 * @date 2018/5/14
 */
public class AccessToken extends Result {

    /**
     * accessToken 获取到的凭证
     */
    private String accessToken;
    /**
     * expiresIn 凭证有效时间，单位：秒
     */
    private String expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

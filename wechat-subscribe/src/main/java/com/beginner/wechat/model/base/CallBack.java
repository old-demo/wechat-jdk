package com.beginner.wechat.model.base;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 微信服务器IP地址
 *
 * @author heqing
 * @date 2018/5/14
 */
public class CallBack extends Result {

    /**
     * callBackId 微信服务器IP地址
     */
    private List<String> callBackId;

    public List<String> getCallBackId() {
        return callBackId;
    }

    public void setCallBackId(List<String> callBackId) {
        this.callBackId = callBackId;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

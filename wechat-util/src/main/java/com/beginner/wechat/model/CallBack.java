package com.beginner.wechat.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 微信服务器IP地址
 *
 * @author heqing
 * @date 2018/5/14
 */
public class CallBack {

    /**
     * callBackId 微信服务器IP地址
     */
    @JSONField(name = "ip_list")
    private List<String> ipList;

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

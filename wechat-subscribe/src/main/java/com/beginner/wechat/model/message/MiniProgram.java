package com.beginner.wechat.model.message;

import com.alibaba.fastjson.JSONObject;

/**
 * @author heqing
 * @date 2018/6/4
 */
public class MiniProgram {

    /**
     * (必传) 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
     */
    private String appid;

    /**
     * (非必传) 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），暂不支持小游戏
     */
    private String pagepath;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

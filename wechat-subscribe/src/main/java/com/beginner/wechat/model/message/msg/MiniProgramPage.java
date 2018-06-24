package com.beginner.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.message.BaseMsg;

/**
 * 小程序卡片
 * @author heqing
 * @date 2018/5/30
 */
public class MiniProgramPage extends BaseMsg {

    /**
     * 标题
     */
    private String title;

    /**
     * 小程序的appid，要求小程序的appid需要与公众号有关联关系
     */
    @JSONField(name = "appid")
    private String appId;

    /**
     * 小程序的页面路径，跟app.json对齐，支持参数，比如pages/index/index?foo=bar
     */
    @JSONField(name = "pagepath")
    private String pagePath;

    /**
     * 小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
     */
    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public MiniProgramPage() {
        this.msgType = MsgType.MINI_PROGRAM_PAGE.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

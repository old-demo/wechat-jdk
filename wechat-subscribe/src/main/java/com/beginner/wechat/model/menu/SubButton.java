package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.constant.ButtonType;

import java.util.List;

/**
 * 二级菜单信息
 * @author heqing
 * @date 2018/5/21
 */
public class SubButton {

    /**
     * 必传<br/>
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     */
    private ButtonType type;

    /**
     * 必传<br/>
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;

    /**
     * click等点击类型必传<br/>
     * 菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    /**
     * view、miniprogram类型必传/网页<br/>
     * 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     */
    private String url;

    /**
     * media_id类型和view_limited类型必传<br/>
     * 调用新增永久素材接口返回的合法media_id
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * miniprogram类型必传<br/>
     * 小程序的appid（仅认证公众号可配置）
     */
    @JSONField(name = "appid")
    private String appId;

    /**
     * pminiprogram类型必传<br/>
     * 小程序的页面路径
     */
    @JSONField(name = "pagepath")
    private String pagePath;

    /**
     * 图文消息的信息 （该字段近用于显示菜单配置，其他接口调用均不需要传）
     * 该字段主要用来显示菜单配置信息
     */
    @JSONField(name = "news_info")
    private List<NewsInfo> newsInfo;

    public String getType() {
        if(type == null) {
            return "";
        } else {
            return type.getName();
        }
    }

    public void setType(ButtonType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
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

    public List<NewsInfo> getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(List<NewsInfo> newsInfo) {
        this.newsInfo = newsInfo;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

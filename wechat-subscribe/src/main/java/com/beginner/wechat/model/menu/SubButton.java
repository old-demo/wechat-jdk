package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.constant.ButtonType;

import java.util.List;

/**
 * 二级菜单信息
 * @author heqing
 * @date 2018/5/21.
 */
public class SubButton {

    /**
     * type
     * 必传
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     */
    private String type;

    /**
     * name
     * 必传
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;

    /**
     * key
     * click等点击类型必须
     * 菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    /**
     * url
     * view、miniprogram类型必须	网页
     * 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     */
    private String url;

    /**
     * media_id
     * media_id类型和view_limited类型必须
     * 调用新增永久素材接口返回的合法media_id
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * appid
     * miniprogram类型必须
     * 小程序的appid（仅认证公众号可配置）
     */
    @JSONField(name = "appid")
    private String appId;

    /**
     * pagepath
     * miniprogram类型必须
     * 小程序的页面路径
     */
    @JSONField(name = "pagepath")
    private String pagePath;

    /**
     * 图文消息的信息
     * 该字段主要用来显示菜单配置信息
     */
    @JSONField(name = "news_info")
    private List<NewsInfo> newsInfo;

    public String getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = ButtonType.getButton(type);
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

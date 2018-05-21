package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.constant.ButtonType;

/**
 * @author heqing
 * @date 2018/5/21.
 */
public class SubButton {

    /**
     * type
     * 必传
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     */
    private ButtonType type;
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

    public String getType() {
        String typeString = null;
        if(type != null) {
            switch (type) {
                case CLICK:
                    typeString = ButtonType.CLICK.getName();
                    break;
                case VIEW:
                    typeString = ButtonType.VIEW.getName();
                    break;
                case SCANCODE_PUSH:
                    typeString = ButtonType.SCANCODE_PUSH.getName();
                    break;
                case SACBCODE_WAITMSG:
                    typeString = ButtonType.SACBCODE_WAITMSG.getName();
                    break;
                case PIC_SYSPHOTO:
                    typeString = ButtonType.PIC_SYSPHOTO.getName();
                    break;
                case PIC_PHOTO_OR_ALBUM:
                    typeString = ButtonType.PIC_PHOTO_OR_ALBUM.getName();
                    break;
                case PIC_WEIXIN:
                    typeString = ButtonType.PIC_WEIXIN.getName();
                    break;
                case LOCATION_SELECT:
                    typeString = ButtonType.LOCATION_SELECT.getName();
                    break;
                case MEDIA_ID:
                    typeString = ButtonType.MEDIA_ID.getName();
                    break;
                case VIEW_LIMITED:
                    typeString = ButtonType.VIEW_LIMITED.getName();
                    break;
                case MINI_PROGRAM:
                    typeString = ButtonType.MINI_PROGRAM.getName();
                    break;
                default:
                    typeString = "";
            }
        }
        return typeString;
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

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

package com.heqing.wechat.constant;

/**
 * 消息类型
 * @author heqing
 * @date 2018/5/30
 */
public enum MsgType {

    /**
     * 文本消息
     */
    TEXT("text"),
    /**
     * 图片消息
     */
    IMAGE("image"),

    /**
     * 语音消息
     */
    VOICE("voice"),

    /**
     * 视频消息
     */
    VIDEO("video"),

    /**
     * 小视频消息
     */
    SHORT_VIDEO("shortvideo"),

    /**
     * 地理位置消息
     */
    LOCATION("location"),

    /**
     * 链接消息
     */
    LINK("link"),

    /**
     * 图文消息（点击跳转到外链）
     */
    NEWS("news"),

    /**
     * 图文消息（点击跳转到图文消息页面）
     */
    MPNEWS("mpnews"),

    /**
     * 音乐
     */
    MUSIC("music"),

    /**
     * 卡券消息
     */
    WXCARD("wxcard"),

    /**
     * 小程序卡片
     */
    MINI_PROGRAM_PAGE("miniprogrampage"),

    /**
     * 事件消息
     */
    EVENT("event");

    MsgType(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

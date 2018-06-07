package com.beginner.wechat.constant;

/**
 * 消息类型
 *
 * @author heqing
 * @date 2018/5/30.
 */
public enum MsgType {

    /**
     * mpnews : 图文消息
     */
    MPNEWS("mpnews"),

    /**
     * music : 音乐
     */
    MUSIC("music"),

    /**
     * wxcard : 卡券消息
     */
    WXCARD("wxcard"),

    /**
     * text : 文本消息
     */
    TEXT("text"),

    /**
     * image : 图片消息
     */
    IMAGE("image"),

    /**
     * voice : 语音消息
     */
    VOICE("voice"),

    /**
     * video : 视频消息
     */
    VIDEO("video"),

    /**
     * shortvideo : 小视频消息
     */
    SHORT_VIDEO("shortvideo"),

    /**
     * location : 地理位置消息
     */
    LOCATION("location"),

    /**
     * link : 链接消息
     */
    LINK("link"),

    /**
     * event : 事件消息
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

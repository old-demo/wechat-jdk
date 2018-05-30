package com.beginner.wechat.constant;

/**
 * 事件类型
 * @author heqing
 * @date 2018/5/30.
 */
public enum EventType {

    /**
     * subscribe : 订阅
     */
    SUBSCRIBE("subscribe"),

    /**
     * unsubscribe : 取消订阅
     */
    UN_SUBSCRIBE("unsubscribe"),

    /**
     * SCAN : 扫描带参数二维码事件
     */
    SCAN("SCAN"),

    /**
     * LOCATION : 上报地理位置事件
     */
    LOCATION("LOCATION"),

    /**
     * CLICK : 点击菜单拉取消息时的事件
     */
    CLICK("CLICK"),

    /**
     * VIEW : 点击菜单跳转链接时的事件
     */
    VIEW("VIEW");

    EventType(String name) {
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

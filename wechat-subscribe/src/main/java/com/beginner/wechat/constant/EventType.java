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
     * SCANCODE_PUSH : 扫码推事件的事件推送
     */
    SCANCODE_PUSH("scancode_push"),

    /**
     * SCANCODE_WAITMSG : 扫码推事件且弹出“消息接收中”提示框的事件推送
     */
    SCANCODE_WAITMSG("scancode_waitmsg"),

    /**
     * PIC_SYSPHOTO : 弹出系统拍照发图的事件推送
     */
    PIC_SYSPHOTO("pic_sysphoto"),

    /**
     * PIC_PHOTO_OR_ALBUM : 弹出拍照或者相册发图的事件推送
     */
    PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),

    /**
     * PIC_WEIXIN : 弹出微信相册发图器的事件推送
     */
    PIC_WEIXIN("pic_weixin"),

    /**
     * LOCATION_SELECT : 弹出地理位置选择器的事件推送
     */
    LOCATION_SELECT("location_select"),

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
    VIEW("VIEW"),

    /**
     * TEMPLATE_SEND_JOBFINISH : 模版消息发送任务完成后，微信服务器会将是否送达成功
     */
    TEMPLATE_SEND_JOBFINISH("TEMPLATESENDJOBFINISH"),

    /**
     * QUALIFICATION_VERIFY_SUCCESS : 资质认证成功
     */
    QUALIFICATION_VERIFY_SUCCESS("qualification_verify_success"),

    /**
     * QUALIFICATION_VERIFY_FAIL : 资质认证失败
     */
    QUALIFICATION_VERIFY_FAIL("qualification_verify_fail"),

    /**
     * NAMING_VERIFY_SUCCESS : 名称认证成功
     */
    NAMING_VERIFY_SUCCESS("naming_verify_success"),

    /**
     * NAMING_VERIFY_FAIL : 名称认证失败
     */
    NAMING_VERIFY_FAIL("naming_verify_fail"),

    /**
     * ANNUAL_RENEW : 年审通知
     */
    ANNUAL_RENEW("annual_renew");

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

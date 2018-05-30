package com.beginner.wechat.constant;

/**
 * 自定义菜单类型
 *
 * 请注意，3到8的所有事件，仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户，旧版本微信
 * 用户点击后将没有回应，开发者也不能正常接收到事件推送。9和10，是专门给第三方平台旗下未微信认证（具体
 * 而言，是资质认证未通过）的订阅号准备的事件类型，它们是没有事件推送的，能力相对受限，其他类型的公众号
 * 不必使用。
 *
 * @author heqing
 * @date 2018/5/17.
 */
public enum ButtonType {

    /**
     * click :  点击推事件用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event的结构
     * 给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与用户
     * 进行交互；
     */
    CLICK(1, "click"),

    /**
     * view : 跳转URL用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授
     * 权获取用户基本信息接口结合，获得用户基本信息。
     */
    VIEW(2, "view"),

    /**
     * scancode_push ：扫码推事件用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果
     * （如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息。
     */
    SCANCODE_PUSH(3, "scancode_push"),

    /**
     * scancode_waitmsg ： 扫码推事件且弹出“消息接收中”提示框用户点击按钮后，微信客户端将调起扫一扫工具，
     * 完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会
     * 收到开发者下发的消息。
     */
    SACNCODE_WAITMSG(4, "scancode_waitmsg"),

    /**
     * pic_sysphoto ：弹出系统拍照发图用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄
     * 的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
     */
    PIC_SYSPHOTO(5, "pic_sysphoto"),

    /**
     * pic_photo_or_album ：弹出拍照或者相册发图用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者
     * “从手机相册选择”。用户选择后即走其他两种流程。
     */
    PIC_PHOTO_OR_ALBUM(6, "pic_photo_or_album"),

    /**
     *  pic_weixin ： 弹出微信相册发图器用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片
     *  发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
     */
    PIC_WEIXIN(7, "pic_weixin"),

    /**
     * location_select ： 弹出地理位置选择器用户点击按钮后，微信客户端将调起地理位置选择工具，
     * 完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收
     * 到开发者下发的消息。
     */
    LOCATION_SELECT(8, "location_select"),

    /**
     * media_id ：下发消息（除文本消息）用户点击media_id类型按钮后，微信服务器会将开发者填写的
     * 永久素材id对应的素材下发给用户，永久素材类型可以是图片、音频、视频、图文消息。请注意：永久
     * 素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
     */
    MEDIA_ID(9, "media_id"),

    /**
     * view_limited ：跳转图文消息URL用户点击view_limited类型按钮后，微信客户端将打开开发者在
     * 按钮中填写的永久素材id对应的图文消息URL，永久素材类型只支持图文消息。请注意：永久素材id必须
     * 是在“素材管理/新增永久素材”接口上传后获得的合法id。
     */
    VIEW_LIMITED(10, "view_limited"),

    /**
     * miniprogram ：小程序
     */
    MINI_PROGRAM(11, "miniprogram");

    ButtonType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    int code;
    String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}

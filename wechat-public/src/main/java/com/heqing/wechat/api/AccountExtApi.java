package com.heqing.wechat.api;

/**
 * 账号管理 微信接口地址
 * @author heqing
 * @date 2018/6/5
 */
public class AccountExtApi extends AccountApi {

    /**
     * 生成二维码ticket
     */
    public final static String ACCOUNT_CREATE_QRCODE = WEIXIN + "/qrcode/create?access_token=TOKEN";

    /**
     * 通过ticket换取二维码
     */
    public final static String ACCOUNT_GET_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

    /**
     * 长链接转短链接
     */
    public final static String ACCOUNT_LONG_TO_SHORT = WEIXIN + "/shorturl?access_token=ACCESS_TOKEN";
}

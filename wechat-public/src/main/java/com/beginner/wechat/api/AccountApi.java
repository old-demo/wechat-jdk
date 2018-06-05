package com.beginner.wechat.api;

/**
 * @author heqing
 * @date 2018/6/5.
 */
public class AccountApi extends BaseApi {

    /**
     * CREATE_QRCODE  生成二维码ticket
     */
    public final static String CREATE_QRCODE = WEIXIN + "/qrcode/create?access_token=TOKEN";

    /**
     * GET_QRCODE  通过ticket换取二维码
     */
    public final static String GET_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";

    /**
     * LONG_TO_SHORT  长链接转短链接
     */
    public final static String LONG_TO_SHORT = WEIXIN + "/shorturl?access_token=ACCESS_TOKEN";
}

package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.account.QRCode;
import com.beginner.wechat.model.message.SendTemplate;

import java.io.File;

/**
 * 账号管理
 * @author heqing
 * @date 2018/6/5.
 */
public interface AccountService {

    /**
     * 生成临时二维码ticket
     *
     * @param accessToken 微信access_token
     * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @param actionName 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，
     *                   QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param sceneStr 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @return
     */
    Result<QRCode> createQRCodeTicket(String accessToken, Integer expireSeconds, String actionName,
                                          Integer sceneId, String sceneStr);

    /**
     * 通过ticket换取二维码
     * 获取二维码ticket后，开发者可用ticket换取二维码图片。请注意，本接口无须登录态即可调用。
     *
     * @param ticket 二维码ticket
     * @param file 文件
     * @return
     */
    Result<String> getQRCodeByTicket(String ticket, File file);

    /**
     * 长链接转短链接
     * 主要使用场景： 开发者用于生成二维码的原链接（商品、支付二维码等）太长导致扫码速度和成功率下降，
     *   将原长链接通过此接口转成短链接再生成二维码将大大提升扫码速度和成功率。
     *
     * @param accessToken 微信access_token
     * @param longUrl 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     * @return
     */
    Result<String> longToShort(String accessToken, String longUrl);

}

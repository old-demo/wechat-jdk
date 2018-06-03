package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.KFAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * 消息管理
 * 多客服升级为新版客服，某些接口不再提服务，详见：
 *  https://mp.weixin.qq.com/cgi-bin/announce?action=getannouncement&key=1464266075&version=12&lang=zh_CN
 *
 * @author heqing
 * @date 2018/5/31.
 */
public interface MsgService {

    /**
     * 处理接收到的微信消息
     *
     * @param request 请求对象
     * @param response 返回对象
     * @param handlerMsgService 处理类
     * @param appid 开发者ID(AppID)
     * @param token 微信基本配置中的Token
     * @param encodingAesKey 微信基本配置中的消息加密密钥
     * @return
     */
    void handlerMsg(HttpServletRequest request, HttpServletResponse response, HandlerMsgService handlerMsgService,
                    String appid, String token, String encodingAesKey);

    /**
     * 校验signature判断是否接入成功
     *
     * @param token 微信基本配置中的Token
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param signature 微信加密签名
     * @return
     */
    boolean checkSignature(String token, String timestamp, String nonce, String signature);

    /**
     * 解析xml并进行相应处理
     *
     * @param xmlStr 接收的消息xml
     * @param handlerMsgService 处理类
     * @return
     */
    String analysisMsg(String xmlStr, HandlerMsgService handlerMsgService);

    /**
     * 添加客服帐号
     *
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickName 客服昵称
     * @param password 登陆密码
     * @return
     */
    @Deprecated
    Result addCustomerService(String accessToken, String account, String nickName, String password);

    /**
     * 修改客服帐号
     *
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickName 客服昵称
     * @param password 登陆密码
     * @return
     */
    @Deprecated
    Result updateCustomerService(String accessToken, String account, String nickName, String password);

    /**
     * 删除客服帐号
     *
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickName 客服昵称
     * @param password 登陆密码
     * @return
     */
    @Deprecated
    Result delCustomerService(String accessToken, String account, String nickName, String password);

    /**
     * 设置客服帐号的头像
     *
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param file 头像图片文件必须是jpg格式，推荐使用640*640大小的图片
     * @return
     */
    @Deprecated
    Result accounteadImgUrl(String accessToken, String account, File file);

    /**
     * 获取所有客服账号
     *
     * @param accessToken 微信access_token
     * @return
     */
    @Deprecated
    Result<List<KFAccount>> listAccount(String accessToken);
}

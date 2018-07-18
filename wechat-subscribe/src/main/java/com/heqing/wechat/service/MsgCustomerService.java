package com.heqing.wechat.service;

import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.message.BaseMsg;
import com.heqing.wechat.model.message.CustomerServiceAccount;

import java.io.File;
import java.util.List;

/**
 * 客户服务 接口
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140547">微信文档--客服消息</a>
 * @see <a href="https://mp.weixin.qq.com/cgi-bin/announce?action=getannouncement&key=1464266075&version=12&lang=zh_CN">微信公告--客服接口更新</a>
 * @author heqing
 * @date 2018/6/4
 */
public interface MsgCustomerService {

    /**
     * 添加客服帐号
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickName 客服昵称
     * @param password 登陆密码
     * @return 微信返回结果
     */
    Result addCustomerService(String accessToken, String account, String nickName, String password);

    /**
     * 修改客服帐号
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickName 客服昵称
     * @param password 登陆密码
     * @return 微信返回结果
     */
    Result updateCustomerService(String accessToken, String account, String nickName, String password);

    /**
     * 删除客服帐号
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickName 客服昵称
     * @param password 登陆密码
     * @return 微信返回结果
     */
    Result delCustomerService(String accessToken, String account, String nickName, String password);

    /**
     * 设置客服帐号的头像
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param file 头像图片文件必须是jpg格式，推荐使用640*640大小的图片
     * @return 微信返回结果
     */
    Result accounteadImgUrl(String accessToken, String account, File file);

    /**
     * 获取所有客服账号
     * @param accessToken 微信access_token
     * @return 客服基本信息列表
     */
    Result<List<CustomerServiceAccount>> listAccount(String accessToken);

    /**
     * 客服发消息
     * @param accessToken 微信access_token
     * @param touser 普通用户openid
     * @param baseMsg 发送的消息
     * @param account （非必传，可为空）完整客服账号，格式为：账号前缀@公众号微信号
     * @return 微信返回结果
     */
    Result sendCustomerMsg(String accessToken, String touser, BaseMsg baseMsg, String account);

    /**
     * 客服发消息
     * @param accessToken 微信access_token
     * @param touser 普通用户openid
     * @param command "Typing"：对用户下发“正在输入"状态
     *                 "CancelTyping"：取消对用户的”正在输入"状态
     * @return 微信返回结果
     */
    Result typing(String accessToken, String touser, String command);
}

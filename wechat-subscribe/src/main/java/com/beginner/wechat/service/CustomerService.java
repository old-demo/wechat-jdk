package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.CustomerServiceAccount;

import java.io.File;
import java.util.List;

/**
 * 客户服务接口
 * @author heqing
 * @date 2018/6/4.
 */
public interface CustomerService {

    /**
     * 添加客服帐号
     *
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param nickName 客服昵称
     * @param password 登陆密码
     * @return
     */
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
    Result delCustomerService(String accessToken, String account, String nickName, String password);

    /**
     * 设置客服帐号的头像
     *
     * @param accessToken 微信access_token
     * @param account 完整客服账号，格式为：账号前缀@公众号微信号
     * @param file 头像图片文件必须是jpg格式，推荐使用640*640大小的图片
     * @return
     */
    Result accounteadImgUrl(String accessToken, String account, File file);

    /**
     * 获取所有客服账号
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result<List<CustomerServiceAccount>> listAccount(String accessToken);
}

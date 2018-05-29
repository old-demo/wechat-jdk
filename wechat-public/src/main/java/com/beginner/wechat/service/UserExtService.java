package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.user.Fans;
import com.beginner.wechat.model.user.User;

import java.util.List;

/**
 * 公众号用户管理接口
 * @author heqing
 * @date 2018/5/29.
 */
public interface UserExtService extends UserService {

    /**
     * 获取多个用户基本信息
     *
     * @param accessToken 微信access_token
     * @param openidList 多个普通用户的标识，对当前公众号唯一
     * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     */
    Result<List<User>> listUserInfo(String accessToken, List<String> openidList, String lang);

    /**
     * 获取多个用户基本信息
     *
     * @param accessToken 微信access_token
     * @param openid 普通用户的标识，对当前公众号唯一
     * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return
     */
    Result<User> getUserInfo(String accessToken, String openid, String lang);

    /**
     * 获取公众号的黑名单列表
     * 黑名单列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
     * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     *
     * @param accessToken 微信access_token
     * @param beginOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    Result<Fans> getBlackFansList(String accessToken, String beginOpenid);

    /**
     * 拉黑用户
     * 公众号可通过该接口来拉黑一批用户，黑名单列表由一串 OpenID （加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
     *
     * @param accessToken 微信access_token
     * @param openidList 	需要拉入黑名单的用户的openid，一次拉黑最多允许20个
     * @return
     */
    Result setBlackFansList(String accessToken, List<String> openidList);

    /**
     * 取消拉黑用户
     * 公众号可通过该接口来拉黑一批用户，黑名单列表由一串 OpenID （加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
     *
     * @param accessToken 微信access_token
     * @param openidList 	需要拉入黑名单的用户的openid，一次拉黑最多允许20个
     * @return
     */
    Result setUnBlackFansList(String accessToken, List<String> openidList);
}

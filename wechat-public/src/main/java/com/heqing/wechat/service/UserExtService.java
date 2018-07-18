package com.heqing.wechat.service;

import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.user.Fans;
import com.heqing.wechat.model.user.User;

import java.util.List;

/**
 * 基本信息/黑名单 接口
 * @author heqing
 * @date 2018/5/29
 */
public interface UserExtService extends UserService {

    /**
     * 获取多个用户基本信息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140839">微信文档-获取用户基本信息</a>
     * @param accessToken 微信access_token
     * @param openidList 多个普通用户的标识，对当前公众号唯一
     * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return 用户信息列表
     */
    Result<List<User>> listUserInfo(String accessToken, List<String> openidList, String lang);

    /**
     * 获取用户基本信息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140839">微信文档-获取用户基本信息</a>
     * @param accessToken 微信access_token
     * @param openid 普通用户的标识，对当前公众号唯一
     * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return 用户信息
     */
    Result<User> getUserInfo(String accessToken, String openid, String lang);

    /**
     * 获取公众号的黑名单列表<br/>
     * 黑名单列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。<br/>
     * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1471422259_pJMWA">微信文档-黑名单管理</a>
     * @param accessToken 微信access_token
     * @param beginOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return 粉丝信息
     */
    Result<Fans> getBlackFansList(String accessToken, String beginOpenid);

    /**
     * 拉黑用户<br/>
     * 公众号可通过该接口来拉黑一批用户，黑名单列表由一串 OpenID （加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1471422259_pJMWA">微信文档-黑名单管理</a>
     * @param accessToken 微信access_token
     * @param openidList 	需要拉入黑名单的用户的openid，一次拉黑最多允许20个
     * @return 微信返回结果
     */
    Result setBlackFansList(String accessToken, List<String> openidList);

    /**
     * 取消拉黑用户<br/>
     * 公众号可通过该接口来拉黑一批用户，黑名单列表由一串 OpenID （加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1471422259_pJMWA">微信文档-黑名单管理</a>
     * @param accessToken 微信access_token
     * @param openidList 	需要拉入黑名单的用户的openid，一次拉黑最多允许20个
     * @return 微信返回结果
     */
    Result setUnBlackFansList(String accessToken, List<String> openidList);
}

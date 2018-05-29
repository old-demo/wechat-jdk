package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.user.Fans;
import com.beginner.wechat.model.user.Tag;

import java.util.List;

/**
 * 用户标签接口
 * @author heqing
 * @date 2018/5/28.
 */
public interface UserService {

    /**
     * 创建标签 （一个公众号，最多可以创建100个标签。）
     *
     * @param accessToken 微信access_token
     * @param name 标签名
     * @return
     */
    Result<Tag> createTag(String accessToken, String name);

    /**
     *  获取公众号已创建的标签
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result<List<Tag>> getTag(String accessToken);

    /**
     * 编辑标签
     *
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @param name 标签名
     * @return
     */
    Result updateTag(String accessToken, Integer tagId, String name);

    /**
     * 删除标签
     *
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @return
     */

    Result deleteTag(String accessToken, Integer tagId);

    /**
     * 获取标签下粉丝列表
     *
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @param nextOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    Result<Fans> getFansListByTag(String accessToken, Integer tagId, String nextOpenid);

    /**
     * 批量为用户打标签
     *
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @param openidList 粉丝列表
     * @return
     */
    Result batchTagging(String accessToken, Integer tagId, List<String> openidList);


    /**
     * 批量为用户取消标签
     *
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @param openidList 粉丝列表
     * @return
     */
    Result batchUnTagging(String accessToken, Integer tagId, List<String> openidList);

    /**
     *  获取用户身上的标签列表
     *
     * @param accessToken 微信access_token
     * @param openId 用户openId
     * @return
     */
    Result<List<Tag>> getTagIdByOpenId(String accessToken, String openId);

    /**
     *  设置用户备注名
     *
     * @param accessToken 微信access_token
     * @param openId 用户openId
     * @param remark 备注
     * @return
     */
    Result updateRemark(String accessToken, String openId, String remark);

    /**
     * 获取用户列表
     * 关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
     * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     *
     * @param accessToken 微信access_token
     * @param nextOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    Result<Fans> getFansList(String accessToken, String nextOpenid);

}

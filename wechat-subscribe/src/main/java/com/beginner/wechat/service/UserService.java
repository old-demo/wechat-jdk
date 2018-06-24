package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.user.Fans;
import com.beginner.wechat.model.user.Tag;

import java.util.List;

/**
 * 用户管理 接口
 * @author heqing
 * @date 2018/5/28
 */
public interface UserService {

    /**
     * 创建标签 （一个公众号，最多可以创建100个标签。）
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140837">微信文档--用户标签管理</a>
     * @param accessToken 微信access_token
     * @param name 标签名
     * @return 用户标签信息
     */
    Result<Tag> createTag(String accessToken, String name);

    /**
     * 获取公众号已创建的标签
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140837">微信文档--用户标签管理</a>
     * @param accessToken 微信access_token
     * @return 用户标签列表
     */
    Result<List<Tag>> getTag(String accessToken);

    /**
     * 编辑标签
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140837">微信文档--用户标签管理</a>
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @param name 标签名
     * @return 微信返回结果
     */
    Result updateTag(String accessToken, Integer tagId, String name);

    /**
     * 删除标签
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140837">微信文档--用户标签管理</a>
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @return 微信返回结果
     */

    Result deleteTag(String accessToken, Integer tagId);

    /**
     * 获取标签下粉丝列表
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140837">微信文档--用户标签管理</a>
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @param nextOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return 标签下的粉丝信息
     */
    Result<Fans> getFansListByTag(String accessToken, Integer tagId, String nextOpenid);

    /**
     * 批量为用户打标签
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140837">微信文档--用户标签管理</a>
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @param openidList 粉丝列表
     * @return 微信返回结果
     */
    Result batchTagging(String accessToken, Integer tagId, List<String> openidList);


    /**
     * 批量为用户取消标签
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140837">微信文档--用户标签管理</a>
     * @param accessToken 微信access_token
     * @param tagId 标签id
     * @param openidList 粉丝列表
     * @return 微信返回结果
     */
    Result batchUnTagging(String accessToken, Integer tagId, List<String> openidList);

    /**
     * 获取用户身上的标签列表
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140837">微信文档--用户标签管理</a>
     * @param accessToken 微信access_token
     * @param openId 用户openId
     * @return
     */
    Result<List<Tag>> getTagIdByOpenId(String accessToken, String openId);

    /**
     * 设置用户备注名
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140838">微信文档--设置用户备注名</a>
     * @param accessToken 微信access_token
     * @param openId 用户openId
     * @param remark 备注
     * @return 微信返回结果
     */
    Result updateRemark(String accessToken, String openId, String remark);

    /**
     * 获取用户列表
     * 关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
     * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140840">微信文档--获取用户列表</a>
     * @param accessToken 微信access_token
     * @param nextOpenid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     */
    Result<Fans> getFansList(String accessToken, String nextOpenid);

}

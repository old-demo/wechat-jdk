package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;

/**
 * 图文消息留言管理 接口
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1494572718_WzHIY">图文消息留言管理接口</a>
 * @author heqing
 * @date 2018/6/4
 */
public interface CommentService {

    /**
     * 打开已群发文章评论
     * @param accessToken 微信access_token
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @return 微信返回结果
     */
    Result openComment(String accessToken, String msgDataId, String index);

    /**
     * 关闭已群发文章评论
     * @param accessToken 微信access_token
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @return 微信返回结果
     */
    Result closeComment(String accessToken, String msgDataId, String index);

    /**
     * 查看指定文章的评论数据
     * @param accessToken 微信access_token
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param begin 起始位置
     * @param count 获取数目（>=50会被拒绝）
     * @param type type=0 普通评论&精选评论 type=1 普通评论 type=2 精选评论
     * @return 微信返回结果
     */
    Result commentList(String accessToken, String msgDataId, String index, String begin, Integer count, Integer type);

    /**
     * 将评论标记精选
     * @param accessToken 微信access_token
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return 微信返回结果
     */
    Result commentMarkelect(String accessToken, String msgDataId, String index, String userCommentId);

    /**
     * 将评论取消精选
     * @param accessToken 微信access_token
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return 微信返回结果
     */
    Result commentUnMarkelect(String accessToken, String msgDataId, String index, String userCommentId);

    /**
     * 删除评论
     * @param accessToken 微信access_token
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return 微信返回结果
     */
    Result deleteComment(String accessToken, String msgDataId, String index, String userCommentId);

    /**
     * 回复评论
     * @param accessToken 微信access_token
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @param content 回复内容
     * @return 微信返回结果
     */
    Result commentAddReply(String accessToken, String msgDataId, String index, String userCommentId, String content);

    /**
     * 删除回复
     * @param accessToken 微信access_token
     * @param msgDataId 群发返回的msg_data_id
     * @param index 多图文时，用来指定第几篇图文，从0开始，不带默认操作该msg_data_id的第一篇图文
     * @param userCommentId 用户评论id
     * @return 微信返回结果
     */
    Result commentDeleteReply(String accessToken, String msgDataId, String index, String userCommentId);
}

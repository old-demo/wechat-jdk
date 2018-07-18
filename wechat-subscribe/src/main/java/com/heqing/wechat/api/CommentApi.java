package com.heqing.wechat.api;

import com.heqing.wechat.api.BaseApi;

/**
 * 微信图文消息留言管理 微信接口地址
 * @author heqing
 * @date 2018/6/4
 */
public class CommentApi extends BaseApi {

    /**
     * 打开已群发文章评论
     */
    public final static String COMMENT_OPEN = WEIXIN + "/comment/open?access_token=ACCESS_TOKEN";

    /**
     * 关闭已群发文章评论
     */
    public final static String COMMENT_CLOSE = WEIXIN + "/comment/close?access_token=ACCESS_TOKEN";

    /**
     * 查看指定文章的评论数据
     */
    public final static String COMMENT_LIST = WEIXIN + "/comment/list?access_token=ACCESS_TOKEN";

    /**
     * 将评论标记精选
     */
    public final static String COMMENT_MARKELECT = WEIXIN + "/comment/markelect?access_token=ACCESS_TOKEN";

    /**
     * 将评论取消精选
     */
    public final static String COMMENT_UN_MARKELECT = WEIXIN + "/comment/unmarkelect?access_token=ACCESS_TOKEN";

    /**
     * 删除评论
     */
    public final static String COMMENT_DELETE = WEIXIN + "/comment/delete?access_token=ACCESS_TOKEN";

    /**
     * 回复评论
     */
    public final static String COMMENT_ADD_REPLY = WEIXIN + "/comment/reply/add?access_token=ACCESS_TOKEN";

    /**
     * 删除回复
     */
    public final static String COMMENT_DELETE_REPLY = WEIXIN + "/comment/reply/delete?access_token=ACCESS_TOKEN";
}

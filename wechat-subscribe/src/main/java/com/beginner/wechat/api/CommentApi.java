package com.beginner.wechat.api;

/**
 * 微信图文消息留言管理接口
 * @author heqing
 * @date 2018/6/4.
 */
public class CommentApi extends BaseApi {

    /**
     * OPEN_COMMENT 打开已群发文章评论
     */
    public final static String OPEN_COMMENT = WEIXIN + "/comment/open?access_token=ACCESS_TOKEN";

    /**
     * CLOSE_COMMENT 关闭已群发文章评论
     */
    public final static String CLOSE_COMMENT = WEIXIN + "/comment/close?access_token=ACCESS_TOKEN";

    /**
     * COMMENT_LIST 查看指定文章的评论数据
     */
    public final static String COMMENT_LIST = WEIXIN + "/comment/list?access_token=ACCESS_TOKEN";

    /**
     * COMMENT_MARKELECT 将评论标记精选
     */
    public final static String COMMENT_MARKELECT = WEIXIN + "/comment/markelect?access_token=ACCESS_TOKEN";

    /**
     * COMMENT_UN_MARKELECT 将评论取消精选
     */
    public final static String COMMENT_UN_MARKELECT = WEIXIN + "/comment/unmarkelect?access_token=ACCESS_TOKEN";

    /**
     * DELETE_COMMENT 删除评论
     */
    public final static String DELETE_COMMENT = WEIXIN + "/comment/delete?access_token=ACCESS_TOKEN";

    /**
     * ADD_REPLY 回复评论
     */
    public final static String ADD_REPLY = WEIXIN + "/comment/reply/add?access_token=ACCESS_TOKEN";

    /**
     * DELETE_REPLY 删除回复
     */
    public final static String DELETE_REPLY = WEIXIN + "/comment/reply/delete?access_token=ACCESS_TOKEN";
}

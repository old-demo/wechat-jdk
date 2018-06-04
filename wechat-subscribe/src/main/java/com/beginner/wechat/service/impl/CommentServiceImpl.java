package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.api.CommentApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.CommentService;
import com.beginner.wechat.util.HttpPostUtil;
import org.springframework.stereotype.Service;

/**
 * 图文消息留言管理
 * @author heqing
 * @date 2018/6/4.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public Result openComment(String accessToken, String msgDataId, String index) {
        String url = CommentApi.OPEN_COMMENT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_data_id", msgDataId);
        params.put("index", index);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result closeComment(String accessToken, String msgDataId, String index) {
        String url = CommentApi.CLOSE_COMMENT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_data_id", msgDataId);
        params.put("index", index);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result commentList(String accessToken, String msgDataId, String index, String begin, Integer count, Integer type) {
        String url = CommentApi.COMMENT_LIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_data_id", msgDataId);
        params.put("index", index);
        params.put("begin", begin);
        params.put("count", count);
        params.put("type", type);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result commentMarkelect(String accessToken, String msgDataId, String index, String userCommentId) {
        String url = CommentApi.COMMENT_MARKELECT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_data_id", msgDataId);
        params.put("index", index);
        params.put("user_comment_id", userCommentId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result commentUnMarkelect(String accessToken, String msgDataId, String index, String userCommentId) {
        String url = CommentApi.COMMENT_UN_MARKELECT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_data_id", msgDataId);
        params.put("index", index);
        params.put("user_comment_id", userCommentId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result deleteComment(String accessToken, String msgDataId, String index, String userCommentId) {
        String url = CommentApi.DELETE_COMMENT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_data_id", msgDataId);
        params.put("index", index);
        params.put("user_comment_id", userCommentId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result commentAddReply(String accessToken, String msgDataId, String index, String userCommentId, String content) {
        String url = CommentApi.ADD_REPLY.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_data_id", msgDataId);
        params.put("index", index);
        params.put("user_comment_id", userCommentId);
        params.put("content", content);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result commentDeleteReply(String accessToken, String msgDataId, String index, String userCommentId) {
        String url = CommentApi.DELETE_REPLY.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_data_id", msgDataId);
        params.put("index", index);
        params.put("user_comment_id", userCommentId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }
}

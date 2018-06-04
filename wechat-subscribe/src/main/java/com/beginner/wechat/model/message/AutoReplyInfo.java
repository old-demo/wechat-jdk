package com.beginner.wechat.model.message;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 自动回复规则
 * @author heqing
 * @date 2018/6/4.
 */
public class AutoReplyInfo {

    /*
     * isAddFriendReplyOpen : 关注后自动回复是否开启，0代表未开启，1代表开启
     */
    @JSONField(name = "is_add_friend_reply_open")
    private Integer isAddFriendReplyOpen;

    /*
     * isAutoreplyOpen :消息自动回复是否开启，0代表未开启，1代表开启
     */
    @JSONField(name = "is_autoreply_open")
    private Integer isAutoreplyOpen;

    /*
     * addFriendAutoreplyInfo :关注后自动回复的信息
     */
    @JSONField(name = "add_friend_autoreply_info")
    private Info addFriendAutoreplyInfo;

    /*
     * messageDefaultAutoreplyInfo :消息自动回复的信息
     */
    @JSONField(name = "message_default_autoreply_info")
    private Info messageDefaultAutoreplyInfo;

    /*
     * keywordAutoreplyInfo :关键词自动回复的信息
     */
    @JSONField(name = "keyword_autoreply_info")
    private List<ReplyInfo> keywordAutoreplyInfo;

    public Integer getIsAddFriendReplyOpen() {
        return isAddFriendReplyOpen;
    }

    public void setIsAddFriendReplyOpen(Integer isAddFriendReplyOpen) {
        this.isAddFriendReplyOpen = isAddFriendReplyOpen;
    }

    public Integer getIsAutoreplyOpen() {
        return isAutoreplyOpen;
    }

    public void setIsAutoreplyOpen(Integer isAutoreplyOpen) {
        this.isAutoreplyOpen = isAutoreplyOpen;
    }

    public Info getAddFriendAutoreplyInfo() {
        return addFriendAutoreplyInfo;
    }

    public void setAddFriendAutoreplyInfo(Info addFriendAutoreplyInfo) {
        this.addFriendAutoreplyInfo = addFriendAutoreplyInfo;
    }

    public Info getMessageDefaultAutoreplyInfo() {
        return messageDefaultAutoreplyInfo;
    }

    public void setMessageDefaultAutoreplyInfo(Info messageDefaultAutoreplyInfo) {
        this.messageDefaultAutoreplyInfo = messageDefaultAutoreplyInfo;
    }

    public List<ReplyInfo> getKeywordAutoreplyInfo() {
        return keywordAutoreplyInfo;
    }

    public void setKeywordAutoreplyInfo(List<ReplyInfo> keywordAutoreplyInfo) {
        this.keywordAutoreplyInfo = keywordAutoreplyInfo;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

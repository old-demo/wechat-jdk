package com.heqing.wechat.model.message;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 回复规则信息
 * @author heqing
 * @date 2018/6/4
 */
public class ReplyInfo {

    /**
     * 规则名称
     */
    @JSONField(name = "rule_name")
    private String ruleName;

    /**
     * 创建时间
     */
    @JSONField(name = "create_time")
    private Long createTime;

    /**
     * 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
     */
    @JSONField(name = "reply_mode")
    private String replyMode;

    /**
     * 匹配的关键词列表
     */
    @JSONField(name = "keyword_list_info")
    private List<Info> keywordListInfo;

    /**
     * 消息自动回复的信息
     */
    @JSONField(name = "reply_list_info")
    private List<Info> replyListInfo;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getReplyMode() {
        return replyMode;
    }

    public void setReplyMode(String replyMode) {
        this.replyMode = replyMode;
    }

    public List<Info> getKeywordListInfo() {
        return keywordListInfo;
    }

    public void setKeywordListInfo(List<Info> keywordListInfo) {
        this.keywordListInfo = keywordListInfo;
    }

    public List<Info> getReplyListInfo() {
        return replyListInfo;
    }

    public void setReplyListInfo(List<Info> replyListInfo) {
        this.replyListInfo = replyListInfo;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

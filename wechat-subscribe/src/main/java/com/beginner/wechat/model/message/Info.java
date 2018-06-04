package com.beginner.wechat.model.message;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.model.menu.NewsInfo;

import java.util.List;

/**
 * @author heqing
 * @date 2018/6/4.
 */
public class Info {

    /**
     * type  自动回复的类型。 关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news）
     */
    private String type;

    /**
     * content :对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
     */
    private String content;

    /**
     * matchMode :匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
     */
    @JSONField(name = "match_mode")
    private String matchMode;

    /**
     * newsInfoList :	图文消息的信息
     */
    @JSONField(name = "news_info")
    private List<NewsInfo> newsInfoList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }

    public List<NewsInfo> getNewsInfoList() {
        return newsInfoList;
    }

    public void setNewsInfoList(List<NewsInfo> newsInfoList) {
        this.newsInfoList = newsInfoList;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

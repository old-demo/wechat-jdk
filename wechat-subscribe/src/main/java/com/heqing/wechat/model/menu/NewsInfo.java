package com.heqing.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 自定义菜单中图文信息
 * 请注意这是自定义菜单编辑中的图文消息，本消息不能通过接口创建
 * @author heqing
 * @date 2018/5/23
 */
public class NewsInfo {

    /**
     * 图文消息的标题
     */
    private String title;

    /**
     * 摘要
     */
    private String digest;

    /**
     * 作者
     */
    private String author;

    /**
     * 是否显示封面，0为不显示，1为显示
     */
    @JSONField(name = "show_cover")
    private String showCover;

    /**
     * 封面图片的URL
     */
    @JSONField(name = "cover_url")
    private String coverUrl;

    /**
     * 正文的URL
     */
    @JSONField(name = "content_url")
    private String contentUrl;

    /**
     * 原文的URL，若置空则无查看原文入口
     */
    @JSONField(name = "source_url")
    private String sourceUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShowCover() {
        return showCover;
    }

    public void setShowCover(String showCover) {
        this.showCover = showCover;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

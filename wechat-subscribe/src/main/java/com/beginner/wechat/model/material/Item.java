package com.beginner.wechat.model.material;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 素材信息
 * @author heqing
 * @date 2018/5/26
 */
public class Item {

    /**
     * 素材id
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 这篇图文消息素材的最后更新时间
     */
    @JSONField(name = "update_time")
    private String updateime;

    /**
     * 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
     */
    private String url;

    /**
     * 图文列表
     */
    @JSONField(name = "content")
    private List<Article> articleList;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateime() {
        return updateime;
    }

    public void setUpdateime(String updateime) {
        this.updateime = updateime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

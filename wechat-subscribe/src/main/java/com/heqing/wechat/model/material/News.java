package com.heqing.wechat.model.material;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 图文信息
 * @author heqing
 * @date 2018/5/24
 */
public class News {

    /**
     * 图文列表
     */
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

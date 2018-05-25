package com.beginner.wechat.model;

import com.beginner.wechat.model.material.Article;
import com.beginner.wechat.model.material.News;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2018/5/24.
 */
public class TestNews {

    public static News getNews() {

        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setTitle("测试图文标题");
        article.setThumbMediaId("i0Ct6iTPmOh3oekG3hHkMf4ggfJhaN6hMVqlgT5NSos");
        article.setAuthor("heqing");
        article.setDigest("测试");
        article.setShowCoverPic("0");
        article.setContent("这只是用来测试的案例");
        article.setContentSourceUrl("www.baidu.com");
        articles.add(article);

        News news = new News();
        news.setArticles(articles);
        return news;
    }
}

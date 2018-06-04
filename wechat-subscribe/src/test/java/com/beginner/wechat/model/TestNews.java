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

    public static Article getArticle() {
        // 创建文章
        Article article = new Article();
        article.setTitle("测试图文标题");
        article.setThumbMediaId("i0Ct6iTPmOh3oekG3hHkMas7IjshdVHSmMOT2Bzk1Ns");
        article.setAuthor("heqing");
        article.setDigest("测试");
        article.setShowCoverPic("0");
        article.setContent("这只是用来测试的案例, <a href=\"http://mmbiz.qpic.cn/mmbiz_jpg/VIicecJdbqqXMAKf2vtTOs5abcsRiaLibA0d0yYqvECPSU8Nic7PdlibOW95hTMCxUZgiamHRf12S6R6LAfqibpfyIwrw/0\">图片</a>");
        article.setContentSourceUrl("www.baidu.com");
        return article;
    }

    public static News getNews() {
        // 创建图文消息
        List<Article> articles = new ArrayList<>();
        articles.add(getArticle());

        News news = new News();
        news.setArticles(articles);
        return news;
    }

}

package com.heqing.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.constant.MsgType;
import com.heqing.wechat.model.message.BaseMsg;
import com.heqing.wechat.model.message.msg.model.Articles;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 图文消息（点击跳转到外链）
 * @author heqing
 * @date 2018/5/30
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class NewsMsg extends BaseMsg {

    /**
     * 图文消息个数，限制为8条以内
     */
    @XmlElement(name = "ArticleCount")
    private String articleCount;

    /**
     * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
     */
    @XmlElementWrapper(name = "Articles")
    @XmlElement(name = "item")
    private List<Articles> articles;

    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public NewsMsg() {
        this.msgType = MsgType.NEWS.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

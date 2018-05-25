package com.beginner.wechat.model.material;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author heqing
 * @date 2018/5/24.
 */
public class Article {

    /**
     * title : 标题 （必传）
     */
    private String title;

    /**
     * thumbMediaId : 图文消息的封面图片素材id（必须是永久mediaID）(必传)
     */
    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    /**
     * author : 作者(非必填)
     */
    private String author;

    /**
     * digest : 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。如果本字段为没有填写，则默认抓取正文前64个字。(非必填)
     */
    private String digest;

    /**
     * showCoverPic : 是否显示封面，0为false，即不显示，1为true，即显示 (必传)
     */
    @JSONField(name = "show_cover_pic")
    private String showCoverPic;

    /**
     * content : 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源 "上传图文消息内的图片获取URL"接口获取。外部图片url将被过滤。
     */
    private String content;

    /**
     * contentSourceUrl : 图文消息的原文地址，即点击“阅读原文”后的URL （必填）
     */
    @JSONField(name = "content_source_url")
    private String contentSourceUrl;

    /**
     * url : 图文页的URL
     */
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getShowCoverPic() {
        return showCoverPic;
    }

    public void setShowCoverPic(String showCoverPic) {
        this.showCoverPic = showCoverPic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

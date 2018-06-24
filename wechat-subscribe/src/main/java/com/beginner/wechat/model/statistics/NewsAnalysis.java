package com.beginner.wechat.model.statistics;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 图文分析数据
 * @author heqing
 * @date 2018/6/5
 */
public class NewsAnalysis {

    /**
     * 数据的日期，需在begin_date和end_date之间
     */
    @JSONField(name = "ref_date")
    private String refDate;

    /**
     * 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时
     */
    @JSONField(name = "ref_hour")
    private String refHour;

    /**
     * 统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期， 而stat_date是数据统计日期
     */
    @JSONField(name = "stat_date")
    private String statDate;

    /**
     * 请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成，
     *   例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个
     */
    @JSONField(name = "msgid")
    private String msgId;

    /**
     * 图文消息的标题
     */
    private String title;

    /**
     * 图文页（点击群发图文卡片进入的页面）的阅读人数
     */
    @JSONField(name = "int_page_read_user")
    private String intPageReadUser;

    /**
     * 图文页的阅读次数
     */
    @JSONField(name = "int_page_read_count")
    private String intPageReadCount;

    /**
     * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    @JSONField(name = "ori_page_read_user")
    private String oriPageReadUser;

    /**
     * 原文页的阅读次数
     */
    @JSONField(name = "ori_page_read_count")
    private String oriPageReadCount;

    /**
     * 分享的场景 1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他
     */
    @JSONField(name = "share_scene")
    private String shareScene;

    /**
     * 分享的人数
     */
    @JSONField(name = "share_user")
    private String shareUser;

    /**
     * 分享的次数
     */
    @JSONField(name = "share_count")
    private String shareCount;

    /**
     * 收藏的人数
     */
    @JSONField(name = "add_to_fav_user")
    private String addToFavUser;

    /**
     * 收藏的次数
     */
    @JSONField(name = "add_to_fav_count")
    private String addToFavCount;

    /**
     * 送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）
     */
    @JSONField(name = "target_user")
    private String targetUer;

    /**
     * 在获取图文阅读分时数据时才有该字段，代表用户从哪里进入来阅读该图文。
     *    0 : 会话;
     *    1 : 好友;
     *    2 : 朋友圈;
     *    3 : 腾讯微博;
     *    4 : 历史消息页;
     *    5 : 其他;
     *    6 : 看一看;
     *    7 : 搜一搜
     */
    @JSONField(name = "user_source")
    private String userSource;

    /**
     * 获取图文群发总数据接口中的详细字段解释
     */
    private List<NewsDetails> details;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public String getRefHour() {
        return refHour;
    }

    public void setRefHour(String refHour) {
        this.refHour = refHour;
    }

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntPageReadUser() {
        return intPageReadUser;
    }

    public void setIntPageReadUser(String intPageReadUser) {
        this.intPageReadUser = intPageReadUser;
    }

    public String getIntPageReadCount() {
        return intPageReadCount;
    }

    public void setIntPageReadCount(String intPageReadCount) {
        this.intPageReadCount = intPageReadCount;
    }

    public String getOriPageReadUser() {
        return oriPageReadUser;
    }

    public void setOriPageReadUser(String oriPageReadUser) {
        this.oriPageReadUser = oriPageReadUser;
    }

    public String getOriPageReadCount() {
        return oriPageReadCount;
    }

    public void setOriPageReadCount(String oriPageReadCount) {
        this.oriPageReadCount = oriPageReadCount;
    }

    public String getShareScene() {
        return shareScene;
    }

    public void setShareScene(String shareScene) {
        this.shareScene = shareScene;
    }

    public String getShareUser() {
        return shareUser;
    }

    public void setShareUser(String shareUser) {
        this.shareUser = shareUser;
    }

    public String getShareCount() {
        return shareCount;
    }

    public void setShareCount(String shareCount) {
        this.shareCount = shareCount;
    }

    public String getAddToFavUser() {
        return addToFavUser;
    }

    public void setAddToFavUser(String addToFavUser) {
        this.addToFavUser = addToFavUser;
    }

    public String getAddToFavCount() {
        return addToFavCount;
    }

    public void setAddToFavCount(String addToFavCount) {
        this.addToFavCount = addToFavCount;
    }

    public String getTargetUer() {
        return targetUer;
    }

    public void setTargetUer(String targetUer) {
        this.targetUer = targetUer;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    public List<NewsDetails> getDetails() {
        return details;
    }

    public void setDetails(List<NewsDetails> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

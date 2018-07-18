package com.heqing.wechat.model.statistics;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 图文分析数据详细字段
 * @author heqing
 * @date 2018/6/5
 */
public class NewsDetails {

    /**
     * 数据的日期
     */
    @JSONField(name = "stat_date")
    private String statDate;

    /**
     * 送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）
     */
    @JSONField(name = "target_user")
    private Long targetUser;

    /**
     * 图文页（点击群发图文卡片进入的页面）的阅读人数
     */
    @JSONField(name = "int_page_read_user")
    private Long intPageReadUser;

    /**
     * 图文页的阅读次数
     */
    @JSONField(name = "int_page_read_count")
    private Long intPageReadCount;

    /**
     * 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0
     */
    @JSONField(name = "ori_page_read_user")
    private Long oriPageReadUser;

    /**
     * 原文页的阅读次数
     */
    @JSONField(name = "ori_page_read_count")
    private Long oriPageReadCount;

    /**
     * 分享的人数
     */
    @JSONField(name = "share_user")
    private Long shareUser;

    /**
     * 分享的次数
     */
    @JSONField(name = "share_count")
    private Long shareCount;

    /**
     * 收藏的人数
     */
    @JSONField(name = "add_to_fav_user")
    private Long addToFavUser;

    /**
     * 收藏的次数
     */
    @JSONField(name = "add_to_fav_count")
    private Long addToFavCount;

    /**
     * 公众号会话阅读人数
     */
    @JSONField(name = "int_page_from_session_read_user")
    private Long intPageFromSessionReadUser;

    /**
     * 公众号会话阅读次数
     */
    @JSONField(name = "int_page_from_session_read_count")
    private Long intPageFromSessionReadCount;

    /**
     * 历史消息页阅读人数
     */
    @JSONField(name = "int_page_from_hist_msg_read_user")
    private Long intPageFromHistMsgReadUser;

    /**
     * 历史消息页阅读次数
     */
    @JSONField(name = "int_page_from_hist_msg_read_count")
    private Long intPageFromHistMsgReadCount;

    /**
     * 朋友圈阅读人数
     */
    @JSONField(name = "int_page_from_feed_read_user")
    private Long intPageFromFeedReadUser;

    /**
     * 朋友圈阅读次数
     */
    @JSONField(name = "int_page_from_feed_read_count")
    private Long intPageFromFeedReadCount;

    /**
     * 好友转发阅读人数
     */
    @JSONField(name = "int_page_from_friends_read_user")
    private Long intPageFromFriendsReadUser;

    /**
     * 好友转发阅读次数
     */
    @JSONField(name = "int_page_from_friends_read_count")
    private Long intPageFromFriendsReadCount;

    /**
     * 其他场景阅读人数
     */
    @JSONField(name = "int_page_from_other_read_user")
    private Long intPageFromOtherReadUser;

    /**
     * 其他场景阅读次数
     */
    @JSONField(name = "int_page_from_other_read_count")
    private Long intPageFromOtherReadCount;

    /**
     * 看一看来源阅读人
     */
    @JSONField(name = "int_page_from_kanyikan_read_user ")
    private Long intPageFromKanyikanReadUser ;

    /**
     * 看一看来源阅读次数
     */
    @JSONField(name = "int_page_from_kanyikan_read_count")
    private Long intPageFromKanyikanReadCount;

    /**
     * 搜一搜来源阅读人
     */
    @JSONField(name = "int_page_from_souyisou_read_user")
    private Long intPageFromSouyisouReadUser;

    /**
     * 搜一搜来源阅读次数
     */
    @JSONField(name = "int_page_from_souyisou_read_count")
    private Long intPageFromSouyisouReadCount;

    /**
     * 公众号会话转发朋友圈人数
     */
    @JSONField(name = "feed_share_from_session_user")
    private Long feedShareFromSessionUser;

    /**
     * 公众号会话转发朋友圈次数
     */
    @JSONField(name = "feed_share_from_session_cnt")
    private Long feedShareFromSessionCnt;

    /**
     * 朋友圈转发朋友圈人数
     */
    @JSONField(name = "feed_share_from_feed_user")
    private Long feedShareFromFeedUser;

    /**
     * 朋友圈转发朋友圈次数
     */
    @JSONField(name = "feed_share_from_feed_cnt")
    private Long feedShareFromFeedCnt;

    /**
     * 其他场景转发朋友圈人数
     */
    @JSONField(name = "feed_share_from_other_user")
    private Long feedShareFromOtherUser;

    /**
     * 其他场景转发朋友圈次数
     */
    @JSONField(name = "feed_share_from_other_cnt")
    private Long feedShareFromOtherCnt;

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public Long getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(Long targetUser) {
        this.targetUser = targetUser;
    }

    public Long getIntPageReadUser() {
        return intPageReadUser;
    }

    public void setIntPageReadUser(Long intPageReadUser) {
        this.intPageReadUser = intPageReadUser;
    }

    public Long getIntPageReadCount() {
        return intPageReadCount;
    }

    public void setIntPageReadCount(Long intPageReadCount) {
        this.intPageReadCount = intPageReadCount;
    }

    public Long getOriPageReadUser() {
        return oriPageReadUser;
    }

    public void setOriPageReadUser(Long oriPageReadUser) {
        this.oriPageReadUser = oriPageReadUser;
    }

    public Long getOriPageReadCount() {
        return oriPageReadCount;
    }

    public void setOriPageReadCount(Long oriPageReadCount) {
        this.oriPageReadCount = oriPageReadCount;
    }

    public Long getShareUser() {
        return shareUser;
    }

    public void setShareUser(Long shareUser) {
        this.shareUser = shareUser;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public Long getAddToFavUser() {
        return addToFavUser;
    }

    public void setAddToFavUser(Long addToFavUser) {
        this.addToFavUser = addToFavUser;
    }

    public Long getAddToFavCount() {
        return addToFavCount;
    }

    public void setAddToFavCount(Long addToFavCount) {
        this.addToFavCount = addToFavCount;
    }

    public Long getIntPageFromSessionReadUser() {
        return intPageFromSessionReadUser;
    }

    public void setIntPageFromSessionReadUser(Long intPageFromSessionReadUser) {
        this.intPageFromSessionReadUser = intPageFromSessionReadUser;
    }

    public Long getIntPageFromSessionReadCount() {
        return intPageFromSessionReadCount;
    }

    public void setIntPageFromSessionReadCount(Long intPageFromSessionReadCount) {
        this.intPageFromSessionReadCount = intPageFromSessionReadCount;
    }

    public Long getIntPageFromHistMsgReadUser() {
        return intPageFromHistMsgReadUser;
    }

    public void setIntPageFromHistMsgReadUser(Long intPageFromHistMsgReadUser) {
        this.intPageFromHistMsgReadUser = intPageFromHistMsgReadUser;
    }

    public Long getIntPageFromHistMsgReadCount() {
        return intPageFromHistMsgReadCount;
    }

    public void setIntPageFromHistMsgReadCount(Long intPageFromHistMsgReadCount) {
        this.intPageFromHistMsgReadCount = intPageFromHistMsgReadCount;
    }

    public Long getIntPageFromFeedReadUser() {
        return intPageFromFeedReadUser;
    }

    public void setIntPageFromFeedReadUser(Long intPageFromFeedReadUser) {
        this.intPageFromFeedReadUser = intPageFromFeedReadUser;
    }

    public Long getIntPageFromFeedReadCount() {
        return intPageFromFeedReadCount;
    }

    public void setIntPageFromFeedReadCount(Long intPageFromFeedReadCount) {
        this.intPageFromFeedReadCount = intPageFromFeedReadCount;
    }

    public Long getIntPageFromFriendsReadUser() {
        return intPageFromFriendsReadUser;
    }

    public void setIntPageFromFriendsReadUser(Long intPageFromFriendsReadUser) {
        this.intPageFromFriendsReadUser = intPageFromFriendsReadUser;
    }

    public Long getIntPageFromFriendsReadCount() {
        return intPageFromFriendsReadCount;
    }

    public void setIntPageFromFriendsReadCount(Long intPageFromFriendsReadCount) {
        this.intPageFromFriendsReadCount = intPageFromFriendsReadCount;
    }

    public Long getIntPageFromOtherReadUser() {
        return intPageFromOtherReadUser;
    }

    public void setIntPageFromOtherReadUser(Long intPageFromOtherReadUser) {
        this.intPageFromOtherReadUser = intPageFromOtherReadUser;
    }

    public Long getIntPageFromOtherReadCount() {
        return intPageFromOtherReadCount;
    }

    public void setIntPageFromOtherReadCount(Long intPageFromOtherReadCount) {
        this.intPageFromOtherReadCount = intPageFromOtherReadCount;
    }

    public Long getIntPageFromKanyikanReadUser() {
        return intPageFromKanyikanReadUser;
    }

    public void setIntPageFromKanyikanReadUser(Long intPageFromKanyikanReadUser) {
        this.intPageFromKanyikanReadUser = intPageFromKanyikanReadUser;
    }

    public Long getIntPageFromKanyikanReadCount() {
        return intPageFromKanyikanReadCount;
    }

    public void setIntPageFromKanyikanReadCount(Long intPageFromKanyikanReadCount) {
        this.intPageFromKanyikanReadCount = intPageFromKanyikanReadCount;
    }

    public Long getIntPageFromSouyisouReadUser() {
        return intPageFromSouyisouReadUser;
    }

    public void setIntPageFromSouyisouReadUser(Long intPageFromSouyisouReadUser) {
        this.intPageFromSouyisouReadUser = intPageFromSouyisouReadUser;
    }

    public Long getIntPageFromSouyisouReadCount() {
        return intPageFromSouyisouReadCount;
    }

    public void setIntPageFromSouyisouReadCount(Long intPageFromSouyisouReadCount) {
        this.intPageFromSouyisouReadCount = intPageFromSouyisouReadCount;
    }

    public Long getFeedShareFromSessionUser() {
        return feedShareFromSessionUser;
    }

    public void setFeedShareFromSessionUser(Long feedShareFromSessionUser) {
        this.feedShareFromSessionUser = feedShareFromSessionUser;
    }

    public Long getFeedShareFromSessionCnt() {
        return feedShareFromSessionCnt;
    }

    public void setFeedShareFromSessionCnt(Long feedShareFromSessionCnt) {
        this.feedShareFromSessionCnt = feedShareFromSessionCnt;
    }

    public Long getFeedShareFromFeedUser() {
        return feedShareFromFeedUser;
    }

    public void setFeedShareFromFeedUser(Long feedShareFromFeedUser) {
        this.feedShareFromFeedUser = feedShareFromFeedUser;
    }

    public Long getFeedShareFromFeedCnt() {
        return feedShareFromFeedCnt;
    }

    public void setFeedShareFromFeedCnt(Long feedShareFromFeedCnt) {
        this.feedShareFromFeedCnt = feedShareFromFeedCnt;
    }

    public Long getFeedShareFromOtherUser() {
        return feedShareFromOtherUser;
    }

    public void setFeedShareFromOtherUser(Long feedShareFromOtherUser) {
        this.feedShareFromOtherUser = feedShareFromOtherUser;
    }

    public Long getFeedShareFromOtherCnt() {
        return feedShareFromOtherCnt;
    }

    public void setFeedShareFromOtherCnt(Long feedShareFromOtherCnt) {
        this.feedShareFromOtherCnt = feedShareFromOtherCnt;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

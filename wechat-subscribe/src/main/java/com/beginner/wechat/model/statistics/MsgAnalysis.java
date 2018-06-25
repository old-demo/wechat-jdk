package com.beginner.wechat.model.statistics;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 消息分析数据
 * @author heqing
 * @date 2018/6/5
 */
public class MsgAnalysis {

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
     * 消息类型，代表含义如下：
     *  1 : 文字
     *  2 : 图片
     *  3 : 语音
     *  4 : 视频
     *  6 : 第三方应用消息（链接消息)
     */
    @JSONField(name = "msg_type")
    private String msgType;

    /**
     * 上行发送了（向公众号发送了）消息的用户数
     */
    @JSONField(name = "msg_user")
    private String msgUser;

    /**
     * 上行发送了消息的消息总数
     */
    @JSONField(name = "msg_count")
    private String msgCount;

    /**
     * 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”
     */
    @JSONField(name = "count_interval")
    private String countInterval;

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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgUser() {
        return msgUser;
    }

    public void setMsgUser(String msgUser) {
        this.msgUser = msgUser;
    }

    public String getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(String msgCount) {
        this.msgCount = msgCount;
    }

    public String getCountInterval() {
        return countInterval;
    }

    public void setCountInterval(String countInterval) {
        this.countInterval = countInterval;
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

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

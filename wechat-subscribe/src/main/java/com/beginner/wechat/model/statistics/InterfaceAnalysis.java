package com.beginner.wechat.model.statistics;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 接口分析数据
 * @author heqing
 * @date 2018/6/5
 */
public class InterfaceAnalysis {

    /**
     * 数据的日期，需在begin_date和end_date之间
     */
    @JSONField(name = "ref_date")
    private String refDate;

    /**
     * 数据的小时
     */
    @JSONField(name = "ref_hour")
    private String refHour;

    /**
     * 通过服务器配置地址获得消息后，被动回复用户消息的次数
     */
    @JSONField(name = "callback_count")
    private String callbackCount;

    /**
     * 上述动作的失败次数
     */
    @JSONField(name = "fail_count")
    private String failCount;

    /**
     * 总耗时，除以callback_count即为平均耗时
     */
    @JSONField(name = "total_time_cost")
    private String totalTimeCost;

    /**
     * 最大耗时
     */
    @JSONField(name = "max_time_cost")
    private String maxTimeCost;

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

    public String getCallbackCount() {
        return callbackCount;
    }

    public void setCallbackCount(String callbackCount) {
        this.callbackCount = callbackCount;
    }

    public String getFailCount() {
        return failCount;
    }

    public void setFailCount(String failCount) {
        this.failCount = failCount;
    }

    public String getTotalTimeCost() {
        return totalTimeCost;
    }

    public void setTotalTimeCost(String totalTimeCost) {
        this.totalTimeCost = totalTimeCost;
    }

    public String getMaxTimeCost() {
        return maxTimeCost;
    }

    public void setMaxTimeCost(String maxTimeCost) {
        this.maxTimeCost = maxTimeCost;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

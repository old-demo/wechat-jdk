package com.heqing.wechat.model.statistics;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户分析数据
 * @author heqing
 * @date 2018/6/5
 */
public class UserAnalysis {

    /**
     * 数据的日期
     */
    @JSONField(name = "ref_date")
    private String refDate;

    /**
     * 用户的渠道，数值代表的含义如下：
     *  0 : 其他合计
     *  1 : 公众号搜索
     *  17: 名片分享
     *  30: 扫描二维码
     *  43: 图文页右上角菜单
     *  51: 支付后关注（在支付完成页）
     *  57: 图文页内公众号名称
     *  75: 公众号文章广告
     *  78: 朋友圈广告
     */
    @JSONField(name = "user_source")
    private Long userSource;

    /**
     * 新增的用户数量
     */
    @JSONField(name = "new_user")
    private Long newUser;

    /**
     * 取消关注的用户数量，new_user减去cancel_user即为净增用户数量
     */
    @JSONField(name = "cancel_user")
    private Long cancelUser;

    /**
     * 总用户量
     */
    @JSONField(name = "cumulate_user")
    private Long cumulateUser;

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public Long getUserSource() {
        return userSource;
    }

    public void setUserSource(Long userSource) {
        this.userSource = userSource;
    }

    public Long getNewUser() {
        return newUser;
    }

    public void setNewUser(Long newUser) {
        this.newUser = newUser;
    }

    public Long getCancelUser() {
        return cancelUser;
    }

    public void setCancelUser(Long cancelUser) {
        this.cancelUser = cancelUser;
    }

    public Long getCumulateUser() {
        return cumulateUser;
    }

    public void setCumulateUser(Long cumulateUser) {
        this.cumulateUser = cumulateUser;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

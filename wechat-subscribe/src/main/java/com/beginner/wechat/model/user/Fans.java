package com.beginner.wechat.model.user;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 标签下的粉丝信息
 * @author heqing
 * @date 2018/5/28
 */
public class Fans {

    /**
     * 获取的粉丝数量
     */
    private Integer count;

    /**
     * 粉丝列表
     */
    @JSONField(name = "openid")
    private List<String> openidList;

    /**
     * 拉取列表最后一个用户的openid
     */
    @JSONField(name = "next_openid")
    private String nextOpenid;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getOpenidList() {
        return openidList;
    }

    public void setOpenidList(List<String> openidList) {
        this.openidList = openidList;
    }

    public String getNextOpenid() {
        return nextOpenid;
    }

    public void setNextOpenid(String nextOpenid) {
        this.nextOpenid = nextOpenid;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

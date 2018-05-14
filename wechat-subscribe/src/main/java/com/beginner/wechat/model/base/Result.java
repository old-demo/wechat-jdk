package com.beginner.wechat.model.base;

import com.alibaba.fastjson.JSONObject;

/**
 * 基本返回信息
 *
 * @author heqing
 * @date 2018/5/14.
 */
public class Result {

    /**
     * errcode 返回码
     */
    private Integer errcode;

    /**
     * errmsg 返回说明
     */
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

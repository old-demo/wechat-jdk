package com.beginner.wechat.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 基本返回信息
 *
 * @author heqing
 * @date 2018/5/14.
 */
public class Result<T> implements Serializable {

    /**
     * errcode 返回码
     */
    private Integer errcode;

    /**
     * errmsg 返回说明
     */
    private String errmsg;

    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

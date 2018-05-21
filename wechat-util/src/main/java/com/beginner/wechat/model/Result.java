package com.beginner.wechat.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 基本返回信息
 *
 * @author heqing
 * @date 2018/5/14.
 */
public class Result<T> implements Serializable {

    public Result() { }

    public Result(JSONObject jsonObject) {
        this.errcode = jsonObject.getInteger("errcode");
        this.errmsg = jsonObject.getString("errmsg");
    }

    public Result(JSONObject jsonObject, Class<T> c) {
        this.errcode = jsonObject.getInteger("errcode");
        if(this.errcode == null || this.errcode == 0){
            this.errcode = 0;
            this.data = JSON.parseObject(jsonObject.toJSONString(), c);
        } else {
            this.errmsg = jsonObject.getString("errmsg");
        }
    }

    public Result(JSONObject jsonObject, String key, Class<T> c) {
        this.errcode = jsonObject.getInteger("errcode");
        if(this.errcode == null || this.errcode == 0){
            this.errcode = 0;
            String json = "";
            if(StringUtils.isEmpty(key)) {
                json = jsonObject.toJSONString();
            } else {
                json = jsonObject.getString(key);
            }
            this.data = JSON.parseObject(json, c);
        } else {
            this.errmsg = jsonObject.getString("errmsg");
        }
    }

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

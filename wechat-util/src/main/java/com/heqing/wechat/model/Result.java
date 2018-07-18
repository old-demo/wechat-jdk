package com.heqing.wechat.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ResourceBundle;

/**
 * 基本返回信息
 * @author heqing
 * @date 2018/5/14
 */
public class Result<T> implements Serializable {

    /**
     * 返回状态码
     */
    private Integer errcode;

    /**
     * 返回说明
     */
    private String errmsg;

    /**
     * 返回数据
     */
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

    public Result() {
        this.errcode = 0;
        this.errmsg = getMsgbyCode(this.errcode, "");
    }

    public Result(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = getMsgbyCode(this.errcode, errmsg);
    }

    public Result(JSONObject jsonObject) {
        Integer errcode = jsonObject.getInteger("errcode");
        String errmsg = jsonObject.getString("errmsg");
        this.errcode = errcode == null ? 0 : errcode;
        this.errmsg = getMsgbyCode(this.errcode, errmsg);
        this.data = (T)jsonObject.get("data");
    }

    public Result(JSONObject jsonObject, Class<T> c) {
        this.errcode = jsonObject.getInteger("errcode");
        String errmsg = jsonObject.getString("errmsg");
        if(this.errcode == null || this.errcode == 0){
            this.errcode = 0;
            this.data = JSON.parseObject(jsonObject.toJSONString(), c);
        }
        this.errmsg = getMsgbyCode(this.errcode, errmsg);
    }

    public Result(JSONObject jsonObject, String key, Class<T> c) {
        this.errcode = jsonObject.getInteger("errcode");
        String errmsg = jsonObject.getString("errmsg");
        if(this.errcode == null || this.errcode == 0){
            this.errcode = 0;
            String json = "";
            if(StringUtils.isEmpty(key)) {
                json = jsonObject.toJSONString();
            } else {
                json = jsonObject.getString(key);
            }
            this.data = JSON.parseObject(json, c);
        }
        this.errmsg = getMsgbyCode(this.errcode, errmsg);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    /**
     * 根据状态码获取配置信息
     *
     * @param code 状态码
     * @param msg 默认消息
     * @return error配置文件中，状态码对应的消息
     */
    private String getMsgbyCode(Integer code, String msg) {
        if(!StringUtils.isEmpty(code)) {
            //状态码配置文件
            ResourceBundle error = ResourceBundle.getBundle("error");
            try {
                msg = error.getString(code + "");
            } catch(Exception e) {
            }
        }
        return msg;
    }
}

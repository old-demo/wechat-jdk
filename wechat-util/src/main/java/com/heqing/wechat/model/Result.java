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
    private Integer errCode;

    /**
     * 返回说明
     */
    private String errMsg;

    /**
     * 返回数据
     */
    private T data;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
        this.errCode = 0;
        this.errMsg = getMsgbyCode(this.errCode, "");
    }

    public Result(Integer errCode, String errmsg) {
        this.errCode = errCode;
        this.errMsg = getMsgbyCode(this.errCode, errmsg);
    }

    public Result(JSONObject jsonObject) {
        Integer errcode = jsonObject.getInteger("errcode");
        String errmsg = jsonObject.getString("errmsg");
        this.errCode = errcode == null ? 0 : errcode;
        this.errMsg = getMsgbyCode(this.errCode, errmsg);
        this.data = (T)jsonObject.get("data");
    }

    public Result(JSONObject jsonObject, Class<T> c) {
        this.errCode = jsonObject.getInteger("errcode");
        String errmsg = jsonObject.getString("errmsg");
        if(this.errCode == null || this.errCode == 0){
            this.errCode = 0;
            this.data = JSON.parseObject(jsonObject.toJSONString(), c);
        }
        this.errMsg = getMsgbyCode(this.errCode, errmsg);
    }

    public Result(JSONObject jsonObject, String key, Class<T> c) {
        this.errCode = jsonObject.getInteger("errcode");
        String errmsg = jsonObject.getString("errmsg");
        if(this.errCode == null || this.errCode == 0){
            this.errCode = 0;
            String json = "";
            if(StringUtils.isEmpty(key)) {
                json = jsonObject.toJSONString();
            } else {
                json = jsonObject.getString(key);
            }
            this.data = JSON.parseObject(json, c);
        }
        this.errMsg = getMsgbyCode(this.errCode, errmsg);
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

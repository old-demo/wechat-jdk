package com.beginner.wechat.model.message;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 客服账号
 * @author heqing
 * @date 2018/6/3
 */
public class CustomerServiceAccount {

    /**
     * 客服工号
     */
    @JSONField(name = "kf_id")
    private String id;

    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号
     */
    @JSONField(name = "kf_account")
    private String account;

    /**
     * 客服昵称，最长6个汉字或12个英文字符
     */
    @JSONField(name = "kf_nick")
    private String nickName;

    /**
     * 客服账号登录密码，格式为密码明文的32位加密MD5值。<br/>
     * 该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码
     */
    private String password;

    /**
     * 客服头像
     */
    @JSONField(name = "kf_headimgurl")
    private String headImgUrl;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

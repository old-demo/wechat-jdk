package com.beginner.wechat.model.user;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author heqing
 * @date 2018/5/22.
 */
public class User {

    @JSONField(name = "user_id")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

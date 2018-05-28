package com.beginner.wechat.model.user;

import com.alibaba.fastjson.JSONObject;

/**
 * 用户标签
 * @author heqing
 * @date 2018/5/28.
 */
public class Tag {

    /**
     * id 标签id，由微信分配
     */
    private Integer id;

    /**
     * name 标签名，UTF8编码
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

package com.beginner.wechat.model.material;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author heqing
 * @date 2018/5/25.
 */
public class Video {

    /**
     * title : 标题
     */
    private String title;

    /**
     * description : 描述
     */
    private String description;

    /**
     * downUrl : 下载链接
     */
    @JSONField(name = "down_url")
    private String downUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

package com.beginner.wechat.model.message;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * @author heqing
 * @date 2018/6/4
 */
public class SendTemplate {

    /**
     * 接收者openid（必传）
     */
    @JSONField(name = "touser")
    private String toUser;

    /**
     * 模板ID（必传）
     */
    @JSONField(name = "template_id")
    private String templateId;

    /**
     * 模板跳转链接（非必传）
     */
    private String url;

    /**
     * 订阅场景值
     */
    private String scene;

    /**
     * 消息标题，15字以内
     */
    private String title;

    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据（非必传）
     */
    @JSONField(name = "miniprogram")
    private MiniProgram miniProgram;

    /**
     * 模板数据
     */
    private Map<String, Keyword> data;

    public static class Keyword {
        private String value;
        private String color;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MiniProgram getMiniProgram() {
        return miniProgram;
    }

    public void setMiniProgram(MiniProgram miniProgram) {
        this.miniProgram = miniProgram;
    }

    public Map<String, Keyword> getData() {
        return data;
    }

    public void setData(Map<String, Keyword> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

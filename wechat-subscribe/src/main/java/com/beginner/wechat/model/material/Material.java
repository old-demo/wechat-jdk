package com.beginner.wechat.model.material;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author heqing
 * @date 2018/5/24.
 */
public class Material {

    /**
     * type : 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    private String type;

    /**
     * mediaId : 媒体文件上传后，获取标识
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * createdAt : 媒体文件上传时间戳
     */
    @JSONField(name = "created_at")
    private String createdAt;

    /**
     * imgUrl : 存放图片URL
     */
    @JSONField(name = "url")
    private String imgUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

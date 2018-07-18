package com.heqing.wechat.model.material;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 素材数量信息
 * @author heqing
 * @date 2018/5/25
 */
public class MaterialCount {

    /**
     * 语音总数量
     */
    @JSONField(name = "voice_count")
    private Integer voiceCount;

    /**
     * 视频总数量
     */
    @JSONField(name = "video_count")
    private Integer videoCount;

    /**
     * 图片总数量
     */
    @JSONField(name = "image_count")
    private Integer imageCount;

    /**
     * 图文总数量
     */
    @JSONField(name = "news_count")
    private Integer newsCount;

    public Integer getVoiceCount() {
        return voiceCount;
    }

    public void setVoiceCount(Integer voiceCount) {
        this.voiceCount = voiceCount;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public Integer getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(Integer newsCount) {
        this.newsCount = newsCount;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

package com.heqing.wechat.model.message.msg;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.heqing.wechat.constant.MsgType;
import com.heqing.wechat.model.message.BaseMsg;

/**
 * 图文消息（点击跳转到图文消息页面）
 * @author heqing
 * @date 2018/5/30
 */
public class MPNewsMsg extends BaseMsg {

    /**
     * 图文消息（点击跳转到图文消息页）的媒体ID，客服发送消息时使用
     */
    @JSONField(name = "media_id")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public MPNewsMsg() {
        this.msgType = MsgType.MPNEWS.getName();
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

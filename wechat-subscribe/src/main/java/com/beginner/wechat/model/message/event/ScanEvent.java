package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.adapter.XmlDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 扫描带参数二维码事件
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class ScanEvent extends BaseMsg {

    /**
     * eventKey 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    @XmlElement(name = "EventKey")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String eventKey;

    /**
     * ticket 二维码的ticket，可用来换取二维码图片
     */
    @XmlElement(name = "Ticket")
    @XmlJavaTypeAdapter(XmlDataAdapter.class)
    private String ticket;

    /**
     * scanCodeInfo 扫描信息
     */
    @XmlElement(name = "ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public ScanCodeInfo getScanCodeInfo() {
        return scanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

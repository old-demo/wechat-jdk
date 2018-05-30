package com.beginner.wechat.model.message.event;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.util.CDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 扫描信息
 * @author heqing
 * @date 2018/5/30.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ScanCodeInfo {

    /**
     * event 扫描类型，一般是qrcode
     */
    @XmlElement(name = "ScanType")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String scanType;

    /**
     * scanResult 扫描结果，即二维码对应的字符串信息
     */
    @XmlElement(name = "ScanResult")
    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String scanResult;

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getScanResult() {
        return scanResult;
    }

    public void setScanResult(String scanResult) {
        this.scanResult = scanResult;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

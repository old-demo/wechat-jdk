package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.beginner.wechat.constant.SexType;
import com.beginner.wechat.constant.SystemType;

/**
 * 匹配规则
 * @author heqing
 * @date 2018/5/22.
 */
public class Matchrule {

    /**
     * tagId
     * 非必传
     * 用户标签的id，可通过用户标签管理接口获取
     */
    @JSONField(name = "tag_id")
    private String tagId;

    /**
     * sex
     * 非必传
     * 性别：男（1）女（2），不填则不做匹配
     */
    private String sex;

    /**
     * clientPlatformType
     * 非必传
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     */
    @JSONField(name = "client_platform_type")
    private String clientPlatformType;

    /**
     * country
     * 非必传
     * 国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String country;

    /**
     * province
     * 非必传
     * 省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String province;

    /**
     * city
     * 非必传
     * 城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String city;

    /**
     * language
     * 非必传
     * 语言信息，是用户在微信中设置的语言
     */
    private String language;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = SexType.getSex(sex);
    }

    public String getClientPlatformType() {
        return clientPlatformType;
    }

    public void setClientPlatformType(SystemType clientPlatformType) {
        this.clientPlatformType = SystemType.getSystem(clientPlatformType);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

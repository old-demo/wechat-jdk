package com.heqing.wechat.constant;

/**
 * 性别类型
 * @author heqing
 * @date 2018/5/22
 */
public enum SexType {

    /**
     * 男
     */
    MAN("1"),

    /**
     * 女
     */
    FEMALE("2");

    SexType(String code) {
        this.code = code;
    }

    String code;

    public String getCode() {
        return code;
    }

}

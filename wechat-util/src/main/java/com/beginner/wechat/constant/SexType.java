package com.beginner.wechat.constant;

/**
 * 性别
 * @author heqing
 * @date 2018/5/22.
 */
public enum SexType {

    /**
     * MAN :  男
     */
    MAN("1"),
    /**
     * FEMALE :  女
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

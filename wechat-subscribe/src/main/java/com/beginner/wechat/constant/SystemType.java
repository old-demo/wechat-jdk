package com.beginner.wechat.constant;

/**
 * 设备系统类型
 * @author heqing
 * @date 2018/5/22
 */
public enum SystemType {

    /**
     * 苹果系统
     */
    IOS("1"),

    /**
     * 安卓系统
     */
    ANDROID("2"),

    /**
     * 其他系统
     */
    OTHERS("3");

    SystemType(String code) {
        this.code = code;
    }

    String code;

    public String getCode() {
        return code;
    }

}

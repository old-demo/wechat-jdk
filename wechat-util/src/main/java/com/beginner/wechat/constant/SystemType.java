package com.beginner.wechat.constant;

/**
 * @author heqing
 * @date 2018/5/22.
 */
public enum SystemType {

    /**
     * IOS :  苹果系统
     */
    IOS("1"),
    /**
     * ANDROID : 安卓系统
     */
    ANDROID("2"),
    /**
     * click :  其他系统
     */
    OTHERS("3");

    SystemType(String code) {
        this.code = code;
    }

    String code;

    public String getCode() {
        return code;
    }

    public static String getSystem(SystemType systemType) {
        String system = null;
        if(systemType != null) {
            switch (systemType) {
                case IOS:
                    system = SystemType.IOS.getCode();
                    break;
                case ANDROID:
                    system = SystemType.ANDROID.getCode();
                    break;
                case OTHERS:
                    system = SystemType.ANDROID.getCode();
                    break;
                default:
                    system = "";
            }
        }
        return system;
    }
}

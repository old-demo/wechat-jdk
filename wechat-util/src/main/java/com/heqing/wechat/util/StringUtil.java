package com.heqing.wechat.util;

import java.io.*;

/**
 * 字符串工具类
 * @author heqing
 * @date 2018/6/1
 */
public class StringUtil {

    private final static String ENCODE = "utf-8";

    /**
     * 将流中的数据转换为字符串
     * @param in 数据流
     * @return 流中的数据
     */
    public static String inputSteamToString(InputStream in){
        String str = "";
        try {
            //最好在将字节流转换为字符流的时候 进行转码
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = bf.readLine()) != null) {
                buffer.append(line);
            }
            str = buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 判断字符串是否不为null
     * @param str 字符串
     * @return 结果
     */
    public static boolean isNotBlank(String str) {
        return !StringUtil.isBlank(str);
    }

    /**
     * 判断字符串是否为null
     * @param str 字符串
     * @return 结果
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * URL 解码
     * @param str 转码后的url
     * @return 解码后url
     */
    public static String getURLDecoder(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * URL 转码
     * @param str 需要转码的url
     * @return 解码后
     */
    public static String getURLEncoder(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}

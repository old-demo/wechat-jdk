package com.beginner.wechat.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 字符串工具类
 * @author heqing
 * @date 2018/6/1.
 */
public class StringUtil {

    public static String inputSteamToString(InputStream in){
        String str = "";
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            //最好在将字节流转换为字符流的时候 进行转码
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = bf.readLine()) != null) {
                buffer.append(line);
            }
            str = buffer.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}

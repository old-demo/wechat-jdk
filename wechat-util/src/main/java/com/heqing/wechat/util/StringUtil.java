package com.heqing.wechat.util;

import java.io.*;

/**
 * 字符串工具类
 * @author heqing
 * @date 2018/6/1
 */
public class StringUtil {

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
}

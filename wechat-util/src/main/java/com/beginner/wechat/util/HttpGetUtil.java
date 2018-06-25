package com.beginner.wechat.util;


import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * http/https get访问工具类
 * @author heqing
 * @date 2018/5/14
 */
public class HttpGetUtil {

    /**
     * 发送get请求,获取json格式的应答
     * @param url 请求路径加参数
     * @return 服务端返回的数据
     */
    public static JSONObject getResponse(String url) {
        return JSONObject.parseObject(sendRequest(url));
    }

    /**
     * 发送get请求
     * @param url 请求路径加参数
     * @return 服务端返回的数据
     */
    public static String sendRequest(String url) {
        String response = "";

        BufferedReader buffReader = null;
        InputStreamReader inReader = null;
        InputStream in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            conn.connect();

            // 定义 BufferedReader输入流来读取URL的响应
            in = conn.getInputStream();
            inReader = new InputStreamReader(in);
            buffReader = new BufferedReader(inReader);
            String line;
            while ((line = buffReader.readLine()) != null) {
                response += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 使用finally块来关闭输入流
            try {
                if(in != null) {
                    in.close();
                }
                if(inReader != null) {
                    inReader.close();
                }
                if (buffReader != null) {
                    buffReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return response;
    }

    /**
     * 发送get请求
     * @param url 请求路径
     * @param param 请求参数
     * @return 服务端返回的数据
     */
    public static String sendRequest(String url, String param){
        String urlNameString = url + "?" + param;
        return sendRequest(urlNameString);
    }
}

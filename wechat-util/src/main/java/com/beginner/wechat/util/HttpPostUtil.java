package com.beginner.wechat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author heqing
 * @date 2018/5/21.
 */
public class HttpPostUtil {

    public static JSONObject getResponse(String url, Object params) {
        return getResponse(url, JSON.toJSONString(params));
    }

    public static JSONObject getResponse(String url, String params) {
        return JSONObject.parseObject(sendJsonRequest(url, params));
    }

    /**
     * post请求连接获取相应数据
     *
     * @param url 请求链接
     * @param params 请求参数（json格式）
     * @return String  上传成功后，微信服务器返回的消息
     */
    public static String sendJsonRequest(String url, String params) {
        StringBuilder response = new StringBuilder();

        OutputStreamWriter out = null;
        BufferedReader reader = null;
        try {
            // 创建URL
            URL httpUrl = new URL(url);
            // 建立连接
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            // 设定请求的方法为"POST"，默认是GET
            conn.setRequestMethod("POST");
            // Post 请求不能使用缓存
            conn.setUseCaches(false);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
            conn.setDoOutput(true);
            // 设定传送的内容类型是json格式
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setInstanceFollowRedirects(true);
            // 连接
            conn.connect();

            // 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象。
            out = new OutputStreamWriter(conn.getOutputStream());
            // 向对象输出流写出数据，这些数据将存到内存缓冲区中
            out.write(params);
            // 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream）
            out.flush();

            // 读取输入流响应数据
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // 断开连接
            conn.disconnect();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(out!=null){
                    out.close();
                }
                if(reader!=null){
                    reader.close();
                }
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return response.toString();
    }

}
package com.beginner.wechat.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * http 访问工具
 *
 * @author heqing
 * @date 2018/5/14
 */
public class HttpGetUtil {

    /**
     * 发送get请求
     * @param url 请求路径
     * @param param 请求参数
     * @return
     */
    public static JSONObject httpGetRequest(String url, String param){
        String urlNameString = url + "?" + param;
        return httpGetRequest(urlNameString);
    }

    /**
     * 发送get请求
     * @param url 请求路径
     * @return
     */
    public static JSONObject httpGetRequest(String url) {
        String response = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                response += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return JSONObject.parseObject(response);
    }

    public static JSONObject getTmpFile(String url, String filePath){
        JSONObject json = new JSONObject();
        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("POST");
            conn.connect();

            //微信服务器生成的文件名称
            String file_name ="temp.txt";
            String content_disposition = conn.getHeaderField("content-disposition");
            if(content_disposition != null) {
                String[] content_arr = content_disposition.split(";");
                if (content_arr.length == 2) {
                    String tmp = content_arr[1];
                    file_name = tmp.substring(tmp.indexOf("\"") + 1, tmp.length() - 1);
                }
            }

            //生成不同文件名称
            File file = new File(filePath+"\\"+file_name);
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            String s = "";
            if(bis != null) {
                FileOutputStream fileOut = new FileOutputStream(file);
                byte[] buf = new byte[1024 * 2];
                while (true) {
                    int read = 0;
                    read = bis.read(buf);
                    if (read == -1) {
                        break;
                    }
                    s = new String(buf);
                    if(!s.contains("errcode")) {
                        fileOut.write(buf, 0, read);
                    } else {
                        break;
                    }
                }
                bis.close();
                fileOut.flush();
                fileOut.close();
            }
            if(s.contains("errcode")) {
                json = JSONObject.parseObject(s);
                file.delete();
            } else if(s.contains("video_url")) {
                json.put("errcode", 0);
                JSONObject video = JSONObject.parseObject(s);
                json.put("data", video.getString("video_url"));
                file.delete();
            } else {
                json.put("errcode", 0);
                json.put("data", file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

}

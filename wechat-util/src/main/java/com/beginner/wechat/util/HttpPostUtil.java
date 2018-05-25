package com.beginner.wechat.util;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author heqing
 * @date 2018/5/21.
 */
public class HttpPostUtil {

    /**
     * post请求连接获取相应数据
     *
     * @param url 请求链接
     * @param params 请求参数（json格式）
     * @return String  上传成功后，微信服务器返回的消息
     */
    public static String sendJsonRequest(String url, String params) {
        String response = "";

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
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
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
            String lines = "";
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                response += lines;
            }
            // 关闭输入流
            reader.close();

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
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return response;
    }

    /**
     * post请求连接获取相应数据
     *
     * @param url 请求链接
     * @param file 上传的文件
     * @return String  上传成功后，微信服务器返回的消息
     */
    public static String sendFile(String url, File file, String title, String introduction) {
        StringBuffer response = new StringBuffer();

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
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
            // 设定数据格式
            conn.setRequestProperty("Charset", "UTF-8");
            String boundary = "----------"+ System.currentTimeMillis();
            // 设定传送的内容类型是form表单
            conn.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);

            // 请求正文信息
            StringBuilder sb = new StringBuilder();
            sb.append("--"+boundary + "\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length()
                    + "\";filename=\""+ file.getName() + "\"\r\n");
            sb.append("--"+boundary + "\r\n");
            sb.append("Content-Disposition: form-data; name=\"description\";\r\n");
            sb.append(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}\r\n", title, introduction));
            sb.append("Content-Type:application/octet-stream\r\n");
            System.out.println("--->"+sb.toString());

            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream outputStream = new DataOutputStream(conn.getOutputStream());
            // 将表头写入输出流中：输出表头
            outputStream.write(head);
            // 把文件以流文件的方式 写入到微信服务器中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();
//            outputStream.write(("--" + boundary + "\r\n").getBytes());
//            outputStream.write("Content-Disposition: form-data; name=\"description\";\r\n\r\n".getBytes());
//            outputStream.write(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}",title,introduction).getBytes());
//            outputStream.write(("\r\n--" + boundary + "--\r\n\r\n").getBytes());

            // 将结尾部分输出到正文
            byte[] foot = ("\r\n--" + boundary + "--\r\n").getBytes("utf-8");
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();

            //5.将微信服务器返回的输入流转换成字符串
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

            String str = null;
            while ((str = reader.readLine()) != null) {
                response.append(str);
            }
            reader.close();

            //关闭连接
            conn.disconnect();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(reader!=null){
                    reader.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return response.toString();
    }




    public static JSONObject sendVideoFile(String url, File file, String title,String introduction) {
        if(!file.exists()) {
            JSONObject json = new JSONObject();
            json.put("errcode", "44001");
            json.put("errmsg", "找不到对应的文件："+file.getAbsolutePath());
            return json;
        }
        String result = "";
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            String boundary = "-----------------------------"+System.currentTimeMillis();
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);

            OutputStream output = conn.getOutputStream();
            output.write(("--" + boundary + "\r\n").getBytes());
            output.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", file.getName()).getBytes());
            output.write("Content-Type: video/mp4 \r\n\r\n".getBytes());
            byte[] data = new byte[1024];
            int len =0;
            FileInputStream input = new FileInputStream(file);
            while((len=input.read(data))>-1){
                output.write(data, 0, len);
            }
            output.write(("--" + boundary + "\r\n").getBytes());
            output.write("Content-Disposition: form-data; name=\"description\";\r\n\r\n".getBytes());
            output.write(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}",title,introduction).getBytes());
            output.write(("\r\n--" + boundary + "--\r\n\r\n").getBytes());
            output.flush();
            output.close();
            input.close();
            InputStream resp = conn.getInputStream();
            StringBuffer sb = new StringBuffer();
            while((len= resp.read(data))>-1)
                sb.append(new String(data,0,len,"utf-8"));
            resp.close();
            result = sb.toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(result);
    }
}
package com.heqing.wechat.util;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 微信多媒体文件工具类
 * @author heqing
 * @date 2018/5/25
 */
public class WechatFileUtil {

    /**
     * 判断文件所在路径是否存在，如果不存在则新建
     * @param file 文件
     */
    public static void isExists(File file) {
        File fileParent = new File(file.getParent());
        if(!fileParent .exists()) {
            fileParent.mkdirs();
        }
    }

    /**
     * 将流存入文件
     * @param is 流
     * @param fileName 文件名
     */
    public static void getFile(InputStream is, String fileName) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(is);
            out = new BufferedOutputStream(new FileOutputStream(fileName));
            int len = -1;
            byte[] b = new byte[1024];
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将字符串存入对应的文件
     * @param content 文件内容
     * @param file 本地文件
     */
    public static void stringToFile(String content, File file) {
        isExists(file);
        ByteArrayInputStream bis = null;
        OutputStream os = null;
        try {
            bis = new ByteArrayInputStream(content.getBytes("utf-8"));
            if(bis != null) {
                os = new FileOutputStream(file);
                byte[] buf = new byte[1024];
                while (true) {
                    int read = bis.read(buf);
                    if (read == -1) {
                        break;
                    }
                    os.write(buf, 0, read);
                }
                os.close();
            }
            bis.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(os != null) {
                    os.flush();
                    os.close();
                }
                if(bis != null) {
                    bis.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 从网络Url中下载文件
     * @param urlStr 网络文件地址
     * @param file 本地文件
     */
    public static void downLoadFromUrl(String urlStr, File file){
        isExists(file);
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 得到输入流
            inputStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.close();
            // 获取自己数组
            byte[] getData = bos.toByteArray();

            // 文件保存位置
            fos = new FileOutputStream(file);
            fos.write(getData);

            // 断开连接
            conn.disconnect();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch(IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 从微信返回的地址下载文件
     * @param url 微信文件地址
     * @param file 本地文件
     */
    public static JSONObject getFile(String url, File file){
        isExists(file);
        JSONObject response = new JSONObject();
        boolean isFile = true;

        FileOutputStream fileOut = null;
        BufferedInputStream bis = null;
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

            // 将微信内容写入文件中
            in = conn.getInputStream();
            bis = new BufferedInputStream(in);
            if(bis != null) {
                fileOut = new FileOutputStream(file);
                byte[] buf = new byte[1024];
                while (true) {
                    int read = bis.read(buf);
                    if (read == -1) {
                        break;
                    }
                    String str = new String(buf);
                    if (str.contains("errcode")) {
                        response = JSONObject.parseObject(str);
                        isFile = false;
                        break;
                    } else if(str.contains("video_url")) {
                        JSONObject video = JSONObject.parseObject(str);
                        String videoUrl = video.getString("video_url");
                        WechatFileUtil.downLoadFromUrl(videoUrl, file);
                        break;
                    } else {
                        fileOut.write(buf, 0, read);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 使用finally块来关闭输入流
            try {
                if (fileOut != null) {
                    fileOut.flush();
                    fileOut.close();
                }
                if(in != null) {
                    in.close();
                }
                if(bis != null) {
                    bis.close();
                }
                // 如果是文件返回文件地址，否则返回内容
                if(!isFile && file != null) {
                    file.delete();
                } else {
                    response.put("errcode", 0);
                    response.put("data", file.getAbsolutePath());
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return response;
    }

    /**
     * 将文件上传到微信服务器中
     * @param url 请求链接
     * @param file 上传的文件
     * @return 上传成功后，微信服务器返回的数据（json格式）
     */
    public static JSONObject jsonSendFile(String url, File file, String title, String introduction) {
        return JSONObject.parseObject(sendFile(url, file, title, introduction));
    }

    /**
     * 将文件上传到微信服务器中
     * @param url 请求链接
     * @param file 上传的文件
     * @return 上传成功后，微信服务器返回的数据
     */
    public static String sendFile(String url, File file, String title, String introduction) {
        StringBuffer response = new StringBuffer();
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        try {
            // 1.建立连接
            URL urlRequest = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlRequest.openConnection();

            // 1.1输入输出设置
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            // 1.2设置请求头信息
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            // 1.3设置边界
            String boundary = "----------" + System.currentTimeMillis();
            conn.setRequestProperty("Content-Type","multipart/form-data; boundary="+ boundary);

            // 请求正文信息
            // 第一部分：
            // 2.将文件头输出到微信服务器
            StringBuilder sb = new StringBuilder();
            sb.append("--" + boundary + "\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length() + "\";filename=\""+ file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");

            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream outputStream = new DataOutputStream(conn.getOutputStream());
            // 将表头写入输出流中：输出表头
            outputStream.write(head);

            // 3.将文件正文部分输出到微信服务器
            // 把文件以流文件的方式 写入到微信服务器中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();

            // 4.将结尾部分输出到微信服务器(定义最后数据分隔线)
            sb = new StringBuilder();
            sb.append("--" + boundary + "\r\n");
            sb.append("Content-Disposition: form-data; name=\"description\";\r\n\r\n");
            sb.append(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}\r\n",title,introduction));
            sb.append("--" + boundary + "\r\n\r\n");
            byte[] foot = sb.toString().getBytes();
            outputStream.write(foot);

            outputStream.flush();
            outputStream.close();

            // 5.将微信服务器返回的输入流转换成字符串
            inputStream = conn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                response.append(str);
            }
            //关闭连接
            conn.disconnect();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            try{
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if(inputStreamReader!=null){
                    inputStreamReader.close();
                }
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return response.toString();
    }
}

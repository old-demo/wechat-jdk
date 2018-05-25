package com.beginner.wechat.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author heqing
 * @date 2018/5/25.
 */
public class FileUtil {

    /**
     * 将字符串存入对应的文件
     *
     * @param content 文件内容
     * @param file 文件
     */
    public static void stringToFile(String content, File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            byte bytes[] = content.getBytes();
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(bytes,0, bytes.length);
            fos.flush();
            fos.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

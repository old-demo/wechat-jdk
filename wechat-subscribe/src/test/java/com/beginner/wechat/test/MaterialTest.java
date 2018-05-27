package com.beginner.wechat.test;

import com.beginner.wechat.constant.MediaType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.TestNews;
import com.beginner.wechat.service.MaterialService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author heqing
 * @date 2018/5/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialTest {

    private final static String TOKEN = "10_3Hh2tkHexFEKo9jJmy7d85a8R-HB3vQ--xnjYK0Pt5F6Mme2hMR5AoW7GZFJ_Fxm9a6aK7QPAosNBopKpN7F0ca0e6qXc_-RGEG65BXNuzciCqSW3TPEv7e4xz8W8bF4u_w7CpXgGmc29A0rOBDjACAHUW";
    
    @Autowired
    MaterialService materialService;
    @Test
    public void testAddTempMaterial() {
        // 新增临时素材
//        File file = new File("E:/test/test.jpg");
//        Result result = materialService.addTempMaterial(TOKEN, MediaType.IMAGE, file);
//        System.out.println("--->"+result);

        File file = new File("E:/test/test.mp4");
        Result result = materialService.addTempMaterial(TOKEN, MediaType.VIDEO, file);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetTempMaterial() {
        // 获取临时素材
        // 图片：8-1qgGj20f40fvEOJe3aNphKsQ3UKKagji-HEvl90ycjYkMJ9yhLqoEmFfsB4ip5
        // 视频：Lyp_iB7rW0FqVOPgxhRZo1cjuxOW1ecXxVUXlG-XJ9Q0XwQaZqDGH0nD4eYhNcA1
        String mediaId = "991CSS9W-bQ6OA_t_JZuXqPLu0uES7M6Jjnct1dzo-qyFwOwbhYtwDljg6z1s3Gc";
        File file = new File("E:/test/1.mp4");
        Result result = materialService.getTempMaterial(TOKEN, mediaId, file);
        System.out.println("--->"+result);
    }

    @Test
    public void testUploadImg() {
        // 上传图文消息内的图片获取URL
        File file = new File("E:/test/test.jpg");
        Result result = materialService.uploadImg(TOKEN, file);
        System.out.println("--->"+result);
    }

    @Test
    public void testAddNews() {
        // 新增永久图文素材
        Result result = materialService.addNews(TOKEN, TestNews.getNews());
        System.out.println("--->"+result);
    }

    @Test
    public void testAddMaterial() {
        // 新增其他类型永久素材
        File file = new File("E:/test/test.jpg");
        Result result = materialService.addMaterial(TOKEN, MediaType.IMAGE, file, "", "");
        System.out.println("1--->"+result);

//        File file = new File("E:/test/test.mp4");
//        Result result = materialService.addMaterial(TOKEN, MediaType.VIDEO, file, "test", "测试");
//        System.out.println("2--->"+result);
    }

    @Test
    public void testGetMaterial() {
        // 获取永久素材
        String imgId = "i0Ct6iTPmOh3oekG3hHkMf4ggfJhaN6hMVqlgT5NSos";  //有问题
        String videoId = "i0Ct6iTPmOh3oekG3hHkMbKZOCXhPRvwVCyTxnIi2cc";
        String newId = "i0Ct6iTPmOh3oekG3hHkMWtu1a4kZvOyRkV_0qKA5Cc";
        File file = new File("E:/test/temp.jpg");
        Result result = materialService.getMaterial(TOKEN, newId, file);
        System.out.println("--->"+result);
    }

    @Test
    public void testDelMaterial() {
        // 删除永久素材
        String imgId = "i0Ct6iTPmOh3oekG3hHkMb2hZ5K0aqEl_qi20Vmgw28";
        Result result = materialService.delMaterial(TOKEN, imgId);
        System.out.println("--->"+result);
    }

    @Test
    public void testUpdateNews() {
        // 修改永久图文素材
        String mediaId = "i0Ct6iTPmOh3oekG3hHkMdzLBYHz5fQe2phQMElaRNo";
        Result result = materialService.updateNews(TOKEN, mediaId, 0, TestNews.getArticle());
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMaterialCount() {
        // 获取素材总数
        Result result = materialService.getMaterialCount(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMaterialList() {
        // 获取素材列表
        Result result = materialService.getMaterialList(TOKEN, MediaType.NEWS, 0, 5);
        System.out.println("--->"+result);
    }

}

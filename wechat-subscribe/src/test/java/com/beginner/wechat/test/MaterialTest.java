package com.beginner.wechat.test;

import com.beginner.wechat.constant.MediaType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.TestNews;
import com.beginner.wechat.service.MaterialService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author heqing
 * @date 2018/5/24.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:/spring-config.xml")
public class MaterialTest {

    private final static String TOKEN = "";
    
    @Autowired
    MaterialService materialService;

    String token = "10_B7K_tghIlgFo3o4FKEodyKolZwi_1C8aiCw1BCOrE8zr73uoxCnhH_maTj7T6YxYeChdkcmbQKA5CGTst5jTn8BJ6TvN15MADd6DyIXnhwrcaF_YMmrdv4A4ST0VSCcACACZJ";

    @Test
    public void testAddTempMaterial() {
        File file = new File("E:\\test\\test.mp4");
        Result result = materialService.addTempMaterial(TOKEN, MediaType.VIDEO, file);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetTempMaterial() {
        String filePath = "E:\\test";
        String mediaId = "_GyNXiJvRRWVefElkeMjBwS3B8WJ7AKocdBjm_3TP5oGDE7Cit9sPg_qpa7V6is9";
        Result result = materialService.getTempMaterial(TOKEN, mediaId, filePath);
        System.out.println("--->"+result);
    }

    @Test
    public void testUploadImg() {
        File file = new File("E:\\test\\test.jpg");
        Result result = materialService.uploadImg(TOKEN, file);
        System.out.println("--->"+result);
    }

    @Test
    public void testAddMaterial() {
//        File file = new File("E:\\test\\test.jpg");
//        Result result = materialService.addMaterial(TOKEN, MediaType.IMAGE, file, "", "");
//        System.out.println("1--->"+result);

        File file = new File("E:\\test\\test.mp4");
        Result result = materialService.addMaterial(TOKEN, MediaType.VIDEO, file, "test", "测试");
        System.out.println("2--->"+result);
    }

    @Test
    public void testAddNews() {
        Result result = materialService.addNews(TOKEN, TestNews.getNews());
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMaterial() {
        String imgId = "i0Ct6iTPmOh3oekG3hHkMVUSAaw-x24AESaqqkcJaYg";
        String videoId = "i0Ct6iTPmOh3oekG3hHkMbm88MrL79oyjjr3RngvHTI";
        String newId = "i0Ct6iTPmOh3oekG3hHkMcehY2rVOEs-Z2VC8TfbmNs";
        File file = new File("E:\\test\\temp.jpg");
        Result result = materialService.getMaterial(TOKEN, videoId, file);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMaterialCount() {
        Result result = materialService.getMaterialCount(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMaterialList() {
        materialService.getMaterialList(TOKEN, MediaType.IMAGE, 0, 5);
    }
}

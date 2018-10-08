package com.heqing.wechat.test;

import com.heqing.wechat.model.Result;
import com.heqing.wechat.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ResourceBundle;

/**
 * 微信公共方法测试类
 *
 * @author heqing
 * @date 2018/5/14
 * @version 0.0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Autowired
    BaseService baseService;

    @Test
    public void testToken() {
        ResourceBundle budleEnv = ResourceBundle.getBundle("wechat_config");
        // 获取微信access_token
        String appid = budleEnv.getString("test.appid");
        String secret = budleEnv.getString("test.appsecret");

        // 获取微信access_token
        Result result = baseService.getAccessToken(appid, secret);
        System.out.println("---->"+result);
    }
}

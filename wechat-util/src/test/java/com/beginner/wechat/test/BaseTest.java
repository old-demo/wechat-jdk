package com.beginner.wechat.test;

import com.beginner.wechat.model.AccessToken;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * @author heqing
 * @date 2018/5/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Autowired
    BaseService baseService;

    private final static String appid = "wx2081831e3e9f99fb";
    private final static String secret = "400977b6a6a1a79d74098ed36c0fad31";

    private final static String TOKEN = "10_L_aAomjDFXil6NL_esx1MKGSyP3SUp5_PsBfA_hhxOMnKWdsIeJUG0-wjP8B87-_n_6zdoq8cyhjSElg-AZVq3v5kdKZWk4ydYsMaVzGnexKoktaEO1Vo7tOs8zKpQkd4NKTRL7hy4O7BA18IELcABAYUB";

    @Test
    public void testToken() {
        // 获取微信access_token
        System.out.println("---->"+baseService.getAccessToken(appid, secret));
    }

    @Test
    public void listCallBackIP() {
        // 获取微信服务器IP地址
        Result result = baseService.listCallBackIP(TOKEN);
        System.out.println("-->"+result);
    }
}

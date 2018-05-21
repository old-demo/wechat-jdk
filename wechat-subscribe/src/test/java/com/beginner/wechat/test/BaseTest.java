package com.beginner.wechat.test;

import com.beginner.wechat.model.AccessToken;
import com.beginner.wechat.model.CallBack;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by heqing on 2018/5/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Autowired
    BaseService baseService;

    private final static String appid = "wx2081831e3e9f99fb";
    private final static String secret = "400977b6a6a1a79d74098ed36c0fad31";

    public String getToken() {
        String token = "";
        Result<AccessToken> result = baseService.getAccessToken(appid, secret);
        if(result.getErrcode() == 0) {
            token = result.getData().getAccessToken();
        }
        return token;
    }

    @Test
    public void testToken() {
        // 获取微信access_token
        System.out.println("-->"+getToken());
    }

    @Test
    public void listCallBackIP() {
        // 获取微信服务器IP地址
        Result<CallBack> result = baseService.listCallBackIP(getToken());
        if(result.getErrcode() == 0) {
            System.out.println("-->"+result.getData());
        }
    }

}

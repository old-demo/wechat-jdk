package com.beginner.wechat.base;

import com.beginner.wechat.model.base.CallBack;
import com.beginner.wechat.service.base.BaseService;
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
    private final static String accessToken = "9_UWcQu61QC5xe641N8YrqqPNJCLTF_13Toc9eFN8_Lo-qyHt2OzpiFOdwwd6DrCewwVYZJM7ZPHK-4NPF1gwEq29p39VP6WnDf6onOFNW0NBw9kJq1KZDs0ZrUbXiBIQxbZARUJxGcLmnbEE9AWOiACAUQI";

    @Test
    public void getToken() {
        System.out.println("-->"+baseService.getAccessToken(appid, secret));
    }

    @Test
    public void listCallBackIP() {
        CallBack callBack = baseService.listCallBackIP(accessToken);
        System.out.println("-->"+callBack.getCallBackId());
    }

}

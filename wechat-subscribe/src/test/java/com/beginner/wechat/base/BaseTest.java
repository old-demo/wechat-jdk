package com.beginner.wechat.base;

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

    @Test
    public void getToken() {
        System.out.println("-->"+baseService.getAccessToken(appid, secret));
    }
}

package com.heqing.wechat.test;

import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.account.WebAccessToken;
import com.heqing.wechat.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

    @Autowired
    AccountService accountService;


    @Test
    public void testGetWebAccessToken() {
        String code = "061y1sHc1ZlPpz0jCnHc1MlFHc1y1sHq";
        Result<WebAccessToken> result = accountService.getWebAccessToken("wx2081831e3e9f99fb", "400977b6a6a1a79d74098ed36c0fad31", code);
        System.out.println("-->"+ result);
    }
}

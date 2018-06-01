package com.beginner.wechat.test;

import com.beginner.wechat.util.WechatMsgUtil;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author heqing
 * @date 2018/6/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SignatureTest {

    public void testGetSignature() {
        String accessToken = "qwertyuiop";
        String timestamp = "123456789";
        String nonce = "1qaz";

//        String signature = WechatMsgUtil.getSignature(accessToken, timestamp, nonce);
    }
}

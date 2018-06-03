package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.TestMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author heqing
 * @date 2018/5/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MsgTest {

    @Autowired
    MsgService msgService;

    @Autowired
    TestMsg testMsg;

    private final static String TOKEN = "10_pngk-LFEAMqlUx2E1gEPQf8qXrZFKrLxV_o7ikaf42a5I-zNCPcddfTq4t1ZYef2xxdjiNvjtIQgJaHlKj08Ix4eDM6jWgHvnX2GP9pOIzkWEj6GA86y9ZXQNQ-hirouP_gsgiQ-4DnA3aVpVLVaADAAQA";

    @Test
    public void handlerMsgTest() {
        String xmlStr =
                "<xml>" +
                        "<ToUserName>111</ToUserName>" +
                        "<FromUserName>222</FromUserName>" +
                        "<CreateTime>1408090816</CreateTime>" +
                        "<MsgType>event</MsgType>" +
                        "<Event>pic_weixin</Event>" +
                        "<EventKey>6</EventKey>" +
                        "<SendPicsInfo>" +
                        "<Count>1</Count>" +
                        "<PicList>" +
                        "<item><PicMd5Sum>1111111</PicMd5Sum></item>" +
                        "<item><PicMd5Sum>2222222</PicMd5Sum></item>" +
                        "</PicList>" +
                        "</SendPicsInfo>" +
                        "</xml>";
        System.out.println("-->"+msgService.analysisMsg(xmlStr, testMsg));
    }

    @Test
    public void addCustomerServiceTest() {
        Result result = msgService.addCustomerService(TOKEN, "975656343@qq.com", "贺小白", "hq246512");
        System.out.println("--->"+result.getData());
    }

    @Test
    public void updateCustomerService() {
        Result result = msgService.updateCustomerService(TOKEN, "975656343@qq.com", "贺小白", "hq246512");
        System.out.println("--->"+result.getData());
    }

    @Test
    public void delCustomerService() {
        Result result = msgService.delCustomerService(TOKEN, "975656343@qq.com", "贺小白", "hq246512");
        System.out.println("--->"+result.getData());
    }

    @Test
    public void accounteadImgUrl() {
        File file = new File("E:/test/test.jpg");
        Result result = msgService.accounteadImgUrl(TOKEN, "975656343@qq.com", file);
        System.out.println("--->"+result.getData());
    }

    @Test
    public void listAccount() {
        Result result = msgService.listAccount(TOKEN);
        System.out.println("--->"+result.getData());
    }
}

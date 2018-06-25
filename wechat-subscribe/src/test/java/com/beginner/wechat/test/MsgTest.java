package com.beginner.wechat.test;

import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.TestMsgHandler;
import com.beginner.wechat.service.MsgMassService;
import com.beginner.wechat.service.MsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    TestMsgHandler testMsg;

    private final static String TOKEN = "10_UehY89RRcgZmo2tKMZbBR41AntfGpFCEw8Ve-irSRQYczC4zjC89ubudYFeWfkMasXCapjMU087ZGnrSp6ZVtymSqUeCT35GpGUNSN7E9JYwUXPwHlxrdQg3VaS93K56vAaiWBPHmZnOCtYLQCViADAEQJ";

    @Test
    public void handlerMsgTest() {
//        String xmlStr =
//                "<xml>" +
//                        "<ToUserName>111</ToUserName>" +
//                        "<FromUserName>222</FromUserName>" +
//                        "<CreateTime>1408090816</CreateTime>" +
//                        "<MsgType>event</MsgType>" +
//                        "<Event>pic_weixin</Event>" +
//                        "<EventKey>6</EventKey>" +
//                        "<SendPicsInfo>" +
//                        "<Count>1</Count>" +
//                        "<PicList>" +
//                        "<item><PicMd5Sum>1111111</PicMd5Sum></item>" +
//                        "<item><PicMd5Sum>2222222</PicMd5Sum></item>" +
//                        "</PicList>" +
//                        "</SendPicsInfo>" +
//                        "</xml>";
        String  xmlStr = "<xml>" +
                        "<ToUserName>111</ToUserName>" +
                        "<FromUserName>222</FromUserName>" +
                         "<CreateTime>123456789</CreateTime>" +
                        "<MsgType>event</MsgType>" +
                        "<Event>subscribe</Event>" +
                "</xml>";
        System.out.println("-->"+msgService.analysisMsg(xmlStr, testMsg));
    }


    @Test
    public void testGetAutoReplyInfo() {
        Result result = msgService.getAutoReplyInfo(TOKEN);
        System.out.println("-->"+result);
    }

    @Test
    public void listCallBackIP() {
        // 获取微信服务器IP地址
        Result result = msgService.listCallBackIP(TOKEN);
        System.out.println("-->"+result);
    }
}

package com.beginner.wechat.service;

import com.alibaba.fastjson.JSON;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.TestMsg;
import com.beginner.wechat.model.message.AutoReplyInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
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
    TestMsg testMsg;

    private final static String TOKEN = "10_UehY89RRcgZmo2tKMZbBR41AntfGpFCEw8Ve-irSRQYczC4zjC89ubudYFeWfkMasXCapjMU087ZGnrSp6ZVtymSqUeCT35GpGUNSN7E9JYwUXPwHlxrdQg3VaS93K56vAaiWBPHmZnOCtYLQCViADAEQJ";

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
    public void testGetAutoReplyInfo() {
        Result result = msgService.getAutoReplyInfo(TOKEN);
        System.out.println("-->"+result);
    }

    @Test
    public void testSendMassAllByTag() {
        Result result = msgService.sendMassAllByTag(TOKEN, false, 2, MsgType.WXCARD, "123dsdajkasd231jhksad", 0);
        System.out.println("-->"+result);
    }

    @Test
    public void testSendMassAllByOpenId() {
        List<String> openIdList = new ArrayList();
        Result result = msgService.sendMassAllByOpenId(TOKEN, openIdList, MsgType.WXCARD, "123dsdajkasd231jhksad", 0);
        System.out.println("-->"+result);
    }

}

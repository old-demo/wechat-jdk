package com.beginner.wechat.test;

import com.alibaba.fastjson.JSON;
import com.beginner.wechat.model.message.msg.*;
import com.beginner.wechat.model.message.event.*;
import com.beginner.wechat.util.XmlUtil;
import org.junit.Test;

/**
 * @author heqing
 * @date 2018/5/30.
 */
public class MessageTest {

    @Test
    public void xmlToObj() {
//        String xmlStr = "" +
//                "<xml>  " +
//                    "<ToUserName>1111111</ToUserName>" +
//                    "<FromUserName>222222222</FromUserName>" +
//                    "<CreateTime>1348831860</CreateTime>" +
//                    "<MsgType>text</MsgType>" +
//                    "<Content>333333333</Content>" +
//                    "<MsgId>1234567890123456</MsgId>" +
//                "</xml>";
//        TextMsg textMsg = (TextMsg)XmlUtil.stringToXml(xmlStr, TextMsg.class);
//        System.out.println(textMsg.toString());
//        System.out.println("--------------------------------------");
//        System.out.println(XmlUtil.objToString(JSON.parseObject(textMsg.toString(), TextMsg.class)));

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
                        "<PicMd5Sum>1111111</PicMd5Sum>" +
                        "<item><PicMd5Sum>2222222</PicMd5Sum></item>" +
                    "</PicList>" +
                "</SendPicsInfo>" +
            "</xml>";
        PicPhotoEvent textMsg = (PicPhotoEvent)XmlUtil.stringToXml(xmlStr, PicPhotoEvent.class);
        System.out.println(textMsg.toString());
        System.out.println("--------------------------------------");
        System.out.println(XmlUtil.objToString(JSON.parseObject(textMsg.toString(), PicPhotoEvent.class)));

    }

}

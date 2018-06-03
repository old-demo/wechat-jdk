package com.beginner.wechat.test;

import com.alibaba.fastjson.JSON;
import com.beginner.wechat.constant.EventType;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.model.message.event.PicPhotoEvent;
import com.beginner.wechat.model.message.msg.ImageMsg;
import com.beginner.wechat.model.message.msg.TextMsg;
import com.beginner.wechat.util.XmlUtil;
import org.junit.Test;

public class XmlTest {

    @Test
    public void xmlToObj() {
//        String xmlStr =
//                "<xml>  " +
//                    "<ToUserName>1111111</ToUserName>" +
//                    "<FromUserName>222222222</FromUserName>" +
//                    "<CreateTime>1348831860</CreateTime>" +
//                    "<MsgType>image</MsgType>" +
//                    "<MediaId>4444444</MediaId>" +
//                    "<MsgId>1234567890123456</MsgId>" +
//                "</xml>";
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

        BaseMsg baseMsg = (TextMsg) XmlUtil.stringToXml(xmlStr, TextMsg.class);
        System.out.println(baseMsg.toString());

        if(MsgType.IMAGE.getName().equals(baseMsg.getMsgType())) {
            System.out.println("------------------------>"+111);
            ImageMsg textMsg = (ImageMsg) XmlUtil.stringToXml(xmlStr, ImageMsg.class);
            System.out.println(textMsg.toString());
            System.out.println("--------------------------------------");
            System.out.println(XmlUtil.objToString(JSON.parseObject(textMsg.toString(), ImageMsg.class)));
        }
        if(EventType.PIC_WEIXIN.getName().equals(baseMsg.getEvent())) {
            System.out.println("------------------------>"+222);
            PicPhotoEvent textMsg = (PicPhotoEvent) XmlUtil.stringToXml(xmlStr, PicPhotoEvent.class);
            System.out.println(textMsg.toString());
            System.out.println("--------------------------------------");
            System.out.println(XmlUtil.objToString(JSON.parseObject(textMsg.toString(), PicPhotoEvent.class)));
        }
    }
}

package com.beginner.wechat.test;

import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.message.msg.TextMsg;
import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

/**
 * @author heqing
 * @date 2018/5/30.
 */
public class MessageTest {

    @Test
    public void xmlToObj() {
        String xmlStr = "<xml>  <ToUserName>1111111</ToUserName>  <FromUserName>222222222</FromUserName>  <CreateTime>1348831860</CreateTime>  <MsgType>text</MsgType>  <Content>333333333</Content>  <MsgId>1234567890123456</MsgId>  </xml>";

        try {
//            xmlStr = xmlStr.replace("xml", "textReqMsg");
            JAXBContext context = JAXBContext.newInstance(TextMsg.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            TextMsg text = (TextMsg)unmarshaller.unmarshal(new StringReader(xmlStr));
            System.out.println("-->"+text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void objToXml() {
        TextMsg text = new TextMsg();
        text.setToUserName("1111111");
        text.setFromUserName("22222222");
        text.setMsgType(MsgType.TEXT);
        text.setContent("3333333333");
        text.setCreateTime(System.currentTimeMillis());

        System.out.println(convertToXml(text));
    }

    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            ByteArrayOutputStream op = new ByteArrayOutputStream();

            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            XMLStreamWriter streamWriter = xof.createXMLStreamWriter(op);
//            CDataXMLStreamWriter cdataStreamWriter = new CDataXMLStreamWriter(streamWriter);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //去掉生成xml的默认报文头。
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            marshaller.setProperty("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler",
                    new CharacterEscapeHandler() {
                        @Override
                        public void escape(char[] ch, int start,int length, boolean isAttVal,
                                           Writer writer) throws IOException {
                            writer.write(ch, start, length);
                        }
                    });

            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}

package com.beginner.wechat.util;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * xml 解析工具类
 * @author heqing
 * @date 2018/5/30.
 */
public class XmlUtil {

    /**
     * 将xml字符串转为java对象
     *
     * @param xmlStr xml字符串
     * @param clazz 对象类型
     * @return java对象
     */
    public static Object stringToXml(String xmlStr, Class clazz) {
        Object ojb = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ojb = unmarshaller.unmarshal(new StringReader(xmlStr));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return ojb;
    }

    /**
     * 将java对象转为xml字符串
     *
     * @param obj java对象
     * @return xml字符串
     */
    public static String objToString(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

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

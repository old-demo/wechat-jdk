package com.heqing.wechat.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * xml数据拼装
 * @author heqing
 * @date 2018/5/30
 */
public class XmlDataAdapter extends XmlAdapter<String, String> {

    @Override
    public String marshal(String str) throws Exception {
        //从javabean到xml的适配方法
        return "<![CDATA[" + str+ "]]>";
    }

    @Override
    public String unmarshal(String str) throws Exception {
        //从xml到javabean的适配方法
        return str;
    }
}

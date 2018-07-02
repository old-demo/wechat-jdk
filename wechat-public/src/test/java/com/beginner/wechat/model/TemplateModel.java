package com.beginner.wechat.model;

import com.beginner.wechat.model.message.SendTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqing
 * @date 2018/6/4.
 */
public class TemplateModel {

    public static SendTemplate getSendTemplate() {
        SendTemplate.Keyword name = new SendTemplate.Keyword();
        name.setValue("贺小白");
        SendTemplate.Keyword num = new SendTemplate.Keyword();
        num.setValue("一");
        Map<String, SendTemplate.Keyword> data = new HashMap<>(16);
        data.put("name", name);
        data.put("num", num);

        SendTemplate sendTemplate = new SendTemplate();
        sendTemplate.setToUser("o0xVxt1HBqcN1zsXswCXFrpVfiWA");
        sendTemplate.setTemplateId("S-FewvHOvxWlV9SchkA6KZ0NzRYOYVwCNk4eQuDz8wo");
        sendTemplate.setUrl("www.baidu.com");
        sendTemplate.setData(data);
        return sendTemplate;
    }
}

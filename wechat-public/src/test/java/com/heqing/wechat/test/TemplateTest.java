package com.heqing.wechat.test;

import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.TemplateModel;
import com.heqing.wechat.service.MsgTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author heqing
 * @date 2018/6/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateTest {

    @Autowired
    MsgTemplateService msgTemplateService;

    private final static String TOKEN = "10_av6wmPSv_o4crc1ehdsrXLX8GifJFey8CDcZn4p2DGCzlOkRPOKO4RT9z2w_z3GeQ25ipn7_azDcJjppvrPQ4f5RuQYFVDdBhmIbOyW_pdlHj5Lk4kUDFH7zYYVE3d40tJj0vFa5PWXOHdLDNRGjAEAHLA";

    @Test
    public void testSetIndustry() {
        // 设置所属行业
        Result result = msgTemplateService.setIndustry(TOKEN, "1", "22");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetIndustry() {
        // 获取设置的行业信息
        Result result = msgTemplateService.getIndustry(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testAddTemplate() {
        // 获得模板ID
        // 6UAN38z6Lx4KbXNi2Lo4IRfpHHrlfrmirC6uPZ0J8Bc
        Result result = msgTemplateService.addTemplate(TOKEN, "TM00015");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetAllTemplate() {
        // 获取模板列表
        Result result = msgTemplateService.getAllTemplate(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testDelTemplate() {
        // 获取模板列表
        Result result = msgTemplateService.delTemplate(TOKEN, "Dyvp3-Ff0cnail_CDSzk1fIc6-9lOkxsQE7exTJbwUE");
        System.out.println("--->"+result);
    }

    @Test
    public void testSendTemplate() {
        // 获取模板列表
        Result result = msgTemplateService.sendTemplate(TOKEN, TemplateModel.getSendTemplate());
        System.out.println("--->"+result);
    }
}

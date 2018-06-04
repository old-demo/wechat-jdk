package com.beginner.wechat.test;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.TemplateModel;
import com.beginner.wechat.service.TemplateService;
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
    TemplateService templateService;

    private final static String TOKEN = "10_av6wmPSv_o4crc1ehdsrXLX8GifJFey8CDcZn4p2DGCzlOkRPOKO4RT9z2w_z3GeQ25ipn7_azDcJjppvrPQ4f5RuQYFVDdBhmIbOyW_pdlHj5Lk4kUDFH7zYYVE3d40tJj0vFa5PWXOHdLDNRGjAEAHLA";

    @Test
    public void testSetIndustry() {
        // 设置所属行业
        Result result = templateService.setIndustry(TOKEN, "1", "22");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetIndustry() {
        // 获取设置的行业信息
        Result result = templateService.getIndustry(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testAddTemplate() {
        // 获得模板ID
        // 6UAN38z6Lx4KbXNi2Lo4IRfpHHrlfrmirC6uPZ0J8Bc
        Result result = templateService.addTemplate(TOKEN, "TM00015");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetAllTemplate() {
        // 获取模板列表
        Result result = templateService.getAllTemplate(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testDelTemplate() {
        // 获取模板列表
        Result result = templateService.delTemplate(TOKEN, "Dyvp3-Ff0cnail_CDSzk1fIc6-9lOkxsQE7exTJbwUE");
        System.out.println("--->"+result);
    }

    @Test
    public void testSendTemplate() {
        // 获取模板列表
        Result result = templateService.sendTemplate(TOKEN, TemplateModel.getSendTemplate());
        System.out.println("--->"+result);
    }
}

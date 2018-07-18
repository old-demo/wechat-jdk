package com.heqing.wechat.test;

import com.heqing.wechat.model.Result;
import com.heqing.wechat.service.MsgCustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author heqing
 * @date 2018/6/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    @Autowired
    MsgCustomerService msgCustomerService;

    private final static String TOKEN = "10_HrMuD_zcqe34PhZ1VSgw4xlFm0JOOBYmcip9I4aOYG7NChWYW3nA7YYaTufAfX58IZbut2eWRrvixJbcYllzyXrSq-qR3YiPAkzJXQ0Fql_EMrcwtxlvsPNvB9E6Jy1YwV_ThV9P-abc4xTPPLGeAJAJFA";

    @Test
    public void addCustomerServiceTest() {
        // 添加客服帐号
        Result result = msgCustomerService.addCustomerService(TOKEN, "o0xVxt1HBqcN1zsXswCXFrpVfiWA", "贺小白", "hq246512");
        System.out.println("--->"+result);
    }

    @Test
    public void updateCustomerService() {
        // 修改客服帐号
        Result result = msgCustomerService.updateCustomerService(TOKEN, "975656343@qq.com", "贺小白", "hq246512");
        System.out.println("--->"+result);
    }

    @Test
    public void delCustomerService() {
        // 删除客服帐号
        Result result = msgCustomerService.delCustomerService(TOKEN, "975656343@qq.com", "贺小白", "hq246512");
        System.out.println("--->"+result);
    }

    @Test
    public void accounteadImgUrl() {
        // 设置客服帐号的头像
        File file = new File("E:/test/test.jpg");
        Result result = msgCustomerService.accounteadImgUrl(TOKEN, "975656343@qq.com", file);
        System.out.println("--->"+result);
    }

    @Test
    public void listAccount() {
        // 获取所有客服账号
        Result result = msgCustomerService.listAccount(TOKEN);
        System.out.println("--->"+result);
    }
}

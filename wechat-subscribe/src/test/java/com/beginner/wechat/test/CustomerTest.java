package com.beginner.wechat.test;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.CustomerService;
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
    CustomerService customerService;

    private final static String TOKEN = "10_HrMuD_zcqe34PhZ1VSgw4xlFm0JOOBYmcip9I4aOYG7NChWYW3nA7YYaTufAfX58IZbut2eWRrvixJbcYllzyXrSq-qR3YiPAkzJXQ0Fql_EMrcwtxlvsPNvB9E6Jy1YwV_ThV9P-abc4xTPPLGeAJAJFA";

    @Test
    public void addCustomerServiceTest() {
        Result result = customerService.addCustomerService(TOKEN, "o0xVxt1HBqcN1zsXswCXFrpVfiWA", "贺小白", "hq246512");
        System.out.println("--->"+result);
    }

    @Test
    public void updateCustomerService() {
        Result result = customerService.updateCustomerService(TOKEN, "975656343@qq.com", "贺小白", "hq246512");
        System.out.println("--->"+result);
    }

    @Test
    public void delCustomerService() {
        Result result = customerService.delCustomerService(TOKEN, "975656343@qq.com", "贺小白", "hq246512");
        System.out.println("--->"+result);
    }

    @Test
    public void accounteadImgUrl() {
        File file = new File("E:/test/test.jpg");
        Result result = customerService.accounteadImgUrl(TOKEN, "975656343@qq.com", file);
        System.out.println("--->"+result);
    }

    @Test
    public void listAccount() {
        Result result = customerService.listAccount(TOKEN);
        System.out.println("--->"+result);
    }
}

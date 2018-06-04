package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
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

    private final static String TOKEN = "10_8_yqnYMZeUgxAAvoUxQ3_Gsrm0oFcCLFzkQKYp_NtBUrCxK7rndP5p0flzvnOQwpPeiRhHRip6gNYpNeQVIjtikvdYbFIdGtlzFhUjz4wLK2MX-eC-3oqSJ0BWGKoN-627KFXfXT0QXD8InKGNCeAGANUJ";

    @Test
    public void addCustomerServiceTest() {
        Result result = customerService.addCustomerService(TOKEN, "975656343@qq.com", "贺小白", "hq246512");
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

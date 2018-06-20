package com.beginner.wechat.test;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.account.QRCode;
import com.beginner.wechat.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author heqing
 * @date 2018/6/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

    @Autowired
    AccountService accountService;

    private final static String TOKEN = "10_XJD1JrwsOBQU0vPwm54kg1lTBnfMEEa5WfVQuVlP5hQvxknck0nehedZunoSE4jrApVPJhdjVFGLJfr4bGYHIGC1t76JIoYLhdMq903mQbts6J3ZBiaDRSVXtAWg4ErDCV9BEfg9Hkg28EuAWLIdADAODA";

    @Test
    public void testCreateQRCodeTicket() {
        Result<QRCode> result = accountService.createQRCodeTicket(TOKEN, null, "QR_LIMIT_SCENE", 123, null);
        System.out.println("--->"+result);
    }

    @Test
    public void testGetQRCodeByTicket() {
        File file = new File("E:/test/qrCode.jpg");
        Result result = accountService.getQRCodeByTicket("gQHQ7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAybUd3d2NWamw5TlQxMDAwMHcwM2EAAgR7NRZbAwQAAAAA", file);
        System.out.println("--->"+result);
    }

    @Test
    public void testLongToShort() {
        Result result = accountService.longToShort(TOKEN, "http://yzcrm.test.111.com.cn/h5v2/index.html#/?userId=1&userName=admin&userRole=2,4,6&platformId=6&currentTime=1528162199023&md5msg=1admin2,4,661528162199023&token=aa551c71f0cea1b7241b36c1987518ea");
        System.out.println("--->"+result);
    }
}

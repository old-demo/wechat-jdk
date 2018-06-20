package com.beginner.wechat.test;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.UserExtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserExtTest {

    private final static String TOKEN = "10__fNw9LwtA3gOaMsLIw-vPVbwOG-njGrVVUVAJEOKPFXlc5Tc3Dr6JBxvAE7a5fl-SgHNi4OqcPZ6n4T8H_-RvPyOFX7hIUqtXk5OLb-RsQrzOYgx0-TRv4tNCGiq5TX26GtXnEx6ZCFHAEFdOFWbAFAKBS";

    @Autowired
    UserExtService userExtService;

    @Test
    public void testGetUserInfo() {
        // 获取用户基本信息(UnionID机制)
        Result result = userExtService.getUserInfo(TOKEN, "oa3070VHNTZojJ-zdhZPIe21ETHs", "");
        System.out.println("--->"+result);
    }

    @Test
    public void testListUserInfo() {
        // 获取多个用户基本信息
        List<String> userList = new ArrayList<>();
        userList.add("oa3070VHNTZojJ-zdhZPIe21ETHs");
        userList.add("o0xVxt1HBqcN1zsXswCXFrpVfiWA");
        Result result = userExtService.listUserInfo(TOKEN, userList, "");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetBlackFansList() {
        // 获取公众号的黑名单列表
        Result result = userExtService.getBlackFansList(TOKEN, "oa3070VHNTZojJ-zdhZPIe21ETHs");
        System.out.println("--->"+result);
    }

    @Test
    public void testSetBlackFansList() {
        // 拉黑用户
        List<String> openidList = new ArrayList<>();
        openidList.add("oa3070VHNTZojJ-zdhZPIe21ETHs");
        Result result = userExtService.setBlackFansList(TOKEN, openidList);
        System.out.println("--->"+result);
    }


    @Test
    public void testSetUnBlackFansList() {
        // 取消拉黑用户
        List<String> openidList = new ArrayList<>();
        openidList.add("oa3070VHNTZojJ-zdhZPIe21ETHs");
        Result result = userExtService.setUnBlackFansList(TOKEN, openidList);
        System.out.println("--->"+result);
    }
}

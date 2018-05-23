package com.beginner.wechat.test;

import com.alibaba.fastjson.JSON;
import com.beginner.wechat.constant.SexType;
import com.beginner.wechat.constant.SystemType;
import com.beginner.wechat.model.TestMenu;
import com.beginner.wechat.model.menu.*;
import com.beginner.wechat.model.user.User;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author heqing
 * @date 2018/5/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTest extends BaseTest {

    @Autowired
    MenuService menuService;

    @Test
    public void testMenuJson() {
        System.out.println("--->"+JSON.toJSONString(TestMenu.getMenu()));
    }

    @Test
    public void testCreateMenu() {
        // 创建自定义菜单
        Result result = menuService.createMenu(getToken(), TestMenu.getMenu());
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMenuInfo() {
        // 获取菜单信息
        Result result = menuService.getMenuInfo(getToken());
        System.out.println("--->"+result.getData());
    }

    @Test
    public void testDelMenu() {
        // 删除自定义菜单
        Result result = menuService.delMenu(getToken());
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMenuConfig() {
        // 获取自定义菜单配置信息
        Result result = menuService.getMenuConfigInfo(getToken());
        System.out.println("--->"+result.getData());
    }

    @Test
    public void testAddConditional() {
        ConditionalMenu menu = new ConditionalMenu();
        Matchrule matchrule = new Matchrule();
        matchrule.setTagId("2");
        matchrule.setSex(SexType.MAN);
        matchrule.setCountry("中国");
        matchrule.setProvince("广东");
        matchrule.setCity("广州");
        matchrule.setClientPlatformType(SystemType.ANDROID);
        matchrule.setLanguage("zh_CN");
        menu.setMatchrule(matchrule);

        // 创建自定义菜单
        Result result = menuService.addConditional(getToken(), menu);
        System.out.println("--->"+result);
    }

    @Test
    public void testDelConditional() {
        ConditionalMenu menu = new ConditionalMenu();
        menu.setMenuId("449043475");
        // 删除个性化菜单
        Result result = menuService.delConditional(getToken(), menu);
        System.out.println("--->"+result);
    }

    @Test
    public void testTryMatch() {
        User user = new User();
        user.setUserId("o0xVxt1HBqcN1zsXswCXFrpVfiWA");
        // 测试个性化菜单匹配结果
        Result result = menuService.tryMatch(getToken(), user);
        System.out.println("--->"+result);
    }

}

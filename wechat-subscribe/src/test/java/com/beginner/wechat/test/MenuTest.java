package com.beginner.wechat.test;

import com.beginner.wechat.model.TestMenu;
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
public class MenuTest {

    private final static String TOKEN = "10_L_aAomjDFXil6NL_esx1MKGSyP3SUp5_PsBfA_hhxOMnKWdsIeJUG0-wjP8B87-_n_6zdoq8cyhjSElg-AZVq3v5kdKZWk4ydYsMaVzGnexKoktaEO1Vo7tOs8zKpQkd4NKTRL7hy4O7BA18IELcABAYUB";

    @Autowired
    MenuService menuService;

    @Test
    public void testCreateMenu() {
        // 创建自定义菜单
        Result result = menuService.createMenu(TOKEN, TestMenu.getMenu());
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMenuInfo() {
        // 获取菜单信息
        Result result = menuService.getMenuInfo(TOKEN);
        System.out.println("--->"+result.getData());
    }

    @Test
    public void testDelMenu() {
        // 删除自定义菜单
        Result result = menuService.delMenu(TOKEN);
        System.out.println("--->"+result);
    }

    @Test
    public void testAddConditional() {
        // 创建个性化菜单
        Result result = menuService.addConditional(TOKEN, TestMenu.getConditionalMenu());
        System.out.println("--->"+result);
    }

    @Test
    public void testDelConditional() {
        // 删除个性化菜单
        Result result = menuService.delConditional(TOKEN, "449945323");
        System.out.println("--->"+result);
    }

    @Test
    public void testTryMatch() {
        // 测试个性化菜单匹配结果
        Result result = menuService.tryMatch(TOKEN, "o0xVxt1HBqcN1zsXswCXFrpVfiWA");
        System.out.println("--->"+result);
    }

    @Test
    public void testGetMenuConfig() {
        // 获取自定义菜单配置信息
        Result result = menuService.getMenuConfigInfo(TOKEN);
        System.out.println("--->"+result.getData());
    }
}

package com.beginner.wechat.service;

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

    private final static String TOKEN = "10_4NCGsb1sizMpgvFt90mhpqb_DTcRT7nC9Cyc8usGiIhi9JomVWcNSXORT6ds9m1dBWl_8cUBqc10zVAPvZeFWmrzjz1fHh3KRM45oTOgXaXuXNob76xiEAl1misdVbI_PgSuBeomUPYIns0KGUUbAHATHH";

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
        Result result = menuService.delConditional(TOKEN, "449198255");
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

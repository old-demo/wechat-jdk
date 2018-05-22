package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.menu.AllMenu;
import com.beginner.wechat.model.menu.ConditionalMenu;
import com.beginner.wechat.model.menu.Menu;
import com.beginner.wechat.model.user.User;

/**
 * 自定义菜单接口
 *
 * @author heqing
 * @date 2018/5/21.
 */
public interface MenuService {

    /**
     * 创建自定义菜单
     *
     * @param accessToken 微信access_token
     * @param menu 菜单
     * @return
     */
    Result createMenu(String accessToken, Menu menu);

    /**
     * 获取自定义菜单信息
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result<AllMenu> getMenuInfo(String accessToken);

    /**
     * 删除自定义菜单
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result delMenu(String accessToken);

    /**
     * 获取自定义菜单配置信息
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result<Menu> getMenuConfigInfo(String accessToken);

    /**
     * 创建个性化菜单
     *
     * @param accessToken 微信access_token
     * @param conditionalMenu 个性化菜单
     * @return
     */
    Result<ConditionalMenu> addConditional(String accessToken, ConditionalMenu conditionalMenu);

    /**
     * 删除个性化菜单
     *
     * @param accessToken 微信access_token
     * @param conditionalMenu 个性化菜单
     * @return
     */
    Result delConditional(String accessToken, ConditionalMenu conditionalMenu);

    /**
     * 测试个性化菜单匹配结果
     *
     * @param accessToken 微信access_token
     * @param user 用户的OpenID，也可以是用户的微信号。
     * @return
     */
    Result<ConditionalMenu> tryMatch(String accessToken, User user);
}

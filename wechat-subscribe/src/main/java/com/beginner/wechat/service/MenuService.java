package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.menu.Menu;

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
    Result<Menu> getMenuInfo(String accessToken);
}

package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.menu.AllMenu;
import com.beginner.wechat.model.menu.ConditionalMenu;
import com.beginner.wechat.model.menu.Menu;
import com.beginner.wechat.model.menu.MenuConfig;

/**
 * 自定义菜单接口
 * @author heqing
 * @date 2018/5/21
 */
public interface MenuService {

    /**
     * 创建自定义菜单<br/>
     * 创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，
     * 如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141013">微信接口文档</a>
     * @param accessToken 微信access_token
     * @param menu 菜单
     * @return
     */
    Result createMenu(String accessToken, Menu menu);

    /**
     * 获取自定义菜单信息<br/>
     * 在设置了个性化菜单后，使用本自定义菜单查询接口可以获取默认菜单和全部个性化菜单信息。
     * @param accessToken 微信access_token
     * @return
     */
    Result<AllMenu> getMenuInfo(String accessToken);

    /**
     * 删除自定义菜单<br/>
     * 在个性化菜单时，调用此接口会删除默认菜单及全部个性化菜单。
     * @param accessToken 微信access_token
     * @return
     */
    Result delMenu(String accessToken);

    /**
     * 创建个性化菜单<br/>
     * 出于安全考虑，一个公众号的所有个性化菜单，最多只能设置为跳转到3个域名下的链接。
     * 创建个性化菜单之前必须先创建默认菜单（默认菜单是指使用普通自定义菜单创建接口创建的菜单）。如果删除默认菜单，个性化菜单也会全部删除。
     * 个性化菜单接口支持用户标签，请开发者注意，当用户身上的标签超过1个时，以最后打上的标签为匹配。
     * @param accessToken 微信access_token
     * @param conditionalMenu 个性化菜单
     * @return 菜单id
     */
    Result<String> addConditional(String accessToken, ConditionalMenu conditionalMenu);

    /**
     * 删除个性化菜单<br/>
     * @param accessToken 微信access_token
     * @param menuId 个性化菜单id
     * @return
     */
    Result delConditional(String accessToken, String menuId);

    /**
     * 测试个性化菜单匹配结果<br/>
     * @param accessToken 微信access_token
     * @param userId 用户的OpenID，也可以是用户的微信号。
     * @return
     */
    Result<ConditionalMenu> tryMatch(String accessToken, String userId);

    /**
     * 获取自定义菜单配置信息<br/>
     * 如果公众号是通过API调用设置的菜单，则返回菜单的开发配置，
     * 而如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置
     * @param accessToken 微信access_token
     * @return
     */
    Result<MenuConfig> getMenuConfigInfo(String accessToken);

}

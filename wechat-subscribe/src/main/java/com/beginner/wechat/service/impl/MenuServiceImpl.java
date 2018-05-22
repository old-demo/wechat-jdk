package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.common.HttpGetUtil;
import com.beginner.wechat.common.HttpPostUtil;
import com.beginner.wechat.constant.api.MenuApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.menu.AllMenu;
import com.beginner.wechat.model.menu.ConditionalMenu;
import com.beginner.wechat.model.menu.Menu;
import com.beginner.wechat.model.user.User;
import com.beginner.wechat.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * 自定义菜单实现类
 *
 * @author heqing
 * @date 2018/5/21.
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public Result createMenu(String accessToken, Menu menu) {
        String url = MenuApi.CREATE_MENU+"?access_token="+accessToken;
        JSONObject jsonObject = HttpPostUtil.sendPost(url, JSON.toJSONString(menu));
        return new Result(jsonObject);
    }

    @Override
    public Result<AllMenu> getMenuInfo(String accessToken) {
        String url = MenuApi.GET_MENU;
        String param = "access_token="+accessToken;
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url, param);
        return new Result(jsonObject, AllMenu.class);
    }

    @Override
    public Result delMenu(String accessToken) {
        String url = MenuApi.DEL_MENU;
        String param = "access_token="+accessToken;
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url, param);
        return new Result(jsonObject);
    }

    @Override
    public Result<Menu> getMenuConfigInfo(String accessToken) {
        String url = MenuApi.GET_MENU_CONFIG;
        String param = "access_token="+accessToken;
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url, param);

        System.out.println("-->"+jsonObject.toJSONString());

        return new Result();
    }

    @Override
    public Result<ConditionalMenu> addConditional(String accessToken, ConditionalMenu conditionalMenu) {
        String url = MenuApi.ADD_CONDITIONAL+"?access_token="+accessToken;
        JSONObject jsonObject = HttpPostUtil.sendPost(url, JSON.toJSONString(conditionalMenu));
        return new Result(jsonObject, ConditionalMenu.class);
    }

    @Override
    public Result delConditional(String accessToken, ConditionalMenu conditionalMenu) {
        String url = MenuApi.DEL_CONDITIONAL+"?access_token="+accessToken;
        JSONObject jsonObject = HttpPostUtil.sendPost(url, JSON.toJSONString(conditionalMenu));
        return new Result(jsonObject);
    }

    @Override
    public Result<ConditionalMenu> tryMatch(String accessToken, User user) {
        String url = MenuApi.TRY_MATCH+"?access_token="+accessToken;
        JSONObject jsonObject = HttpPostUtil.sendPost(url, JSON.toJSONString(user));
        return new Result(jsonObject, "menu", ConditionalMenu.class);
    }

}

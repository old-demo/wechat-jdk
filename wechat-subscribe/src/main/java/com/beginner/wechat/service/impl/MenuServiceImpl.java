package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.common.HttpGetUtil;
import com.beginner.wechat.common.HttpPostUtil;
import com.beginner.wechat.constant.api.BaseApi;
import com.beginner.wechat.constant.api.MenuApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.menu.Menu;
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
        String url = MenuApi.MENU_CREATE+"?access_token="+accessToken;
        JSONObject jsonObject = HttpPostUtil.sendPost(url, JSON.toJSONString(menu));
        return new Result(jsonObject);
    }

    @Override
    public Result<Menu> getMenuInfo(String accessToken) {
        String url = MenuApi.MENU_GET;
        String param = "access_token="+accessToken;
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url, param);
        return new Result(jsonObject, "menu", Menu.class);
    }
}

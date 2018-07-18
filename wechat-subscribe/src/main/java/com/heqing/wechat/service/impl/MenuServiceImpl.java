package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.model.menu.AllMenu;
import com.heqing.wechat.model.menu.ConditionalMenu;
import com.heqing.wechat.model.menu.Menu;
import com.heqing.wechat.model.menu.MenuConfig;
import com.heqing.wechat.util.HttpGetUtil;
import com.heqing.wechat.util.HttpPostUtil;
import com.heqing.wechat.api.MenuApi;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * 自定义菜单 实现类
 * @author heqing
 * @date 2018/5/21
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public Result createMenu(String accessToken, Menu menu) {
        String url = MenuApi.MENU_CREATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, menu);
        return new Result(response);
    }

    @Override
    public Result<AllMenu> getMenuInfo(String accessToken) {
        String url = MenuApi.MENU_GET.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        return new Result(response, AllMenu.class);
    }

    @Override
    public Result delMenu(String accessToken) {
        String url = MenuApi.MENU_DELETE.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        return new Result(response);
    }

    @Override
    public Result<String> addConditional(String accessToken, ConditionalMenu conditionalMenu) {
        String url = MenuApi.MENU_ADD_CONDITIONAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, conditionalMenu);
        String menuId = response.getString("menuid");
        response.put("data", menuId == null ? "" : menuId);
        return new Result(response);
    }

    @Override
    public Result delConditional(String accessToken, String menuId) {
        String url = MenuApi.MENU_DEL_CONDITIONAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("menuid", menuId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result<ConditionalMenu> tryMatch(String accessToken, String userId) {
        String url = MenuApi.MENU_TRY_MATCH.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("user_id", userId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response, "menu", ConditionalMenu.class);
    }

    @Override
    public Result<MenuConfig> getMenuConfigInfo(String accessToken) {
        String url = MenuApi.MENU_GET_CURRENT_INFO.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        Result result = new Result();
        result.setErrcode(response.getInteger("errcode"));
        if(result.getErrcode() == null || result.getErrcode()== 0){
            JSONObject selfmenuInfo = response.getJSONObject("selfmenu_info");
            JSONArray buttonList = selfmenuInfo.getJSONArray("button");
            for(int i=0; i<buttonList.size(); i++) {
                JSONObject button = buttonList.getJSONObject(i);
                JSONObject subButton = button.getJSONObject("sub_button");
                JSONArray subButtonList = subButton.getJSONArray("list");
                for(int j=0; j<subButtonList.size(); j++) {
                    JSONObject news = subButtonList.getJSONObject(j);
                    JSONObject newsInfo = news.getJSONObject("news_info");
                    if(newsInfo != null) {
                        JSONArray newsList = newsInfo.getJSONArray("list");
                        news.put("news_info", newsList);
                    }
                }
                button.put("sub_button", subButtonList);
            }
            result.setData(JSON.parseObject(response.toJSONString(), MenuConfig.class));
        } else {
            result.setErrmsg(response.getString("errmsg"));
        }
        return result;
    }
}

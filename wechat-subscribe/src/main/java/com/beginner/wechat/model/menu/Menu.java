package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 自定义菜单信息
 * @author heqing
 * @date 2018/5/21.
 */
public class Menu {

    @JSONField(name = "menuid")
    private String menuId;

    private List<Button> button;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

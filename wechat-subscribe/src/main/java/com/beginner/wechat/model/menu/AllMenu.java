package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 菜单信息
 * @author heqing
 * @date 2018/5/22.
 */
public class AllMenu {

    /**
     * menu 自定义菜单
     */
    private Menu menu;

    /**
     * conditionalMenu 个性化菜单
     */
    @JSONField(name = "conditionalmenu")
    private List<ConditionalMenu> conditionalMenu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<ConditionalMenu> getConditionalMenu() {
        return conditionalMenu;
    }

    public void setConditionalMenu(List<ConditionalMenu> conditionalMenu) {
        this.conditionalMenu = conditionalMenu;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

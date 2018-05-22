package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 自定义菜单配置
 * @author heqing
 * @date 2018/5/23.
 */
public class MenuConfig {

    @JSONField(name = "is_menu_open")
    private Integer isMenuOpen;

    @JSONField(name = "selfmenu_info")
    private Menu selfMenuInfo;

    public Integer getIsMenuOpen() {
        return isMenuOpen;
    }

    public void setIsMenuOpen(Integer isMenuOpen) {
        this.isMenuOpen = isMenuOpen;
    }

    public Menu getSelfMenuInfo() {
        return selfMenuInfo;
    }

    public void setSelfMenuInfo(Menu selfMenuInfo) {
        this.selfMenuInfo = selfMenuInfo;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}

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

    /**
     * button 一级菜单（最多3个，每个最多4个汉字，多出来的部分将会以“...”代替）
     */
    private List<Button> button;

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

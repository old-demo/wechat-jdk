package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author heqing
 * @date 2018/5/21.
 */
public class Menu {

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

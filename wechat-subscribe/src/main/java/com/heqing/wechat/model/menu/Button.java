package com.heqing.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 一级菜单信息
 * @author heqing
 * @date 2018/5/21
 */
public class Button extends SubButton {

    /**
     * 二级菜单 （每个一级菜单最多5个二级， 每个二级最多7个汉字，多出来的部分将会以“...”代替）
     */
    @JSONField(name = "sub_button")
    private List<SubButton> subButton;

    public List<SubButton> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<SubButton> subButton) {
        this.subButton = subButton;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

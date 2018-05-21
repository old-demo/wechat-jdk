package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author heqing
 * @date 2018/5/21.
 */
public class Button extends SubButton {

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

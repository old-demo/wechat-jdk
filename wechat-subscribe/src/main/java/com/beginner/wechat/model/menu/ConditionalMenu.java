package com.beginner.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;

/**
 * 个性化菜单信息
 * @author heqing
 * @date 2018/5/22.
 */
public class ConditionalMenu extends Menu {

    private Matchrule matchrule;

    public Matchrule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(Matchrule matchrule) {
        this.matchrule = matchrule;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

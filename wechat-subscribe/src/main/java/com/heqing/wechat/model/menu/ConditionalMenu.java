package com.heqing.wechat.model.menu;

import com.alibaba.fastjson.JSONObject;

/**
 * 个性化菜单信息
 * @author heqing
 * @date 2018/5/22
 */
public class ConditionalMenu extends Menu {

    /**
     * 匹配规则 （均可为空，但不能全部为空，至少要有一个匹配信息是不为空的。）
     * country、province、city组成地区信息，将按照country、province、city的顺序进行验证，要符合地区信息表的内容。
     * 地区信息从大到小验证，小的可以不填，即若填写了省份信息，则国家信息也必填并且匹配，城市信息可以不填。
     */
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

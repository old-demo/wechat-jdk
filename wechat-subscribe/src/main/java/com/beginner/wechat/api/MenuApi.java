package com.beginner.wechat.api;

/**
 * 自定义菜单微信接口地址
 * @author heqing
 * @date 2018/5/21
 */
public class MenuApi extends BaseApi {

    /**
     * 创建自定义菜单
     */
    public final static String CREATE_MENU = WEIXIN + "/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 获取自定义菜单信息
     */
    public final static String GET_MENU = WEIXIN + "/menu/get?access_token=ACCESS_TOKEN";

    /**
     * 删除自定义菜单
     */
    public final static String DEL_MENU = WEIXIN + "/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * 获取自定义菜单配置信息
     */
    public final static String GET_MENU_CONFIG = WEIXIN + "/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

    /**
     * 创建个性化菜单
     */
    public final static String ADD_CONDITIONAL = WEIXIN + "/menu/addconditional?access_token=ACCESS_TOKEN";

    /**
     * 删除个性化菜单
     */
    public final static String DEL_CONDITIONAL = WEIXIN + "/menu/delconditional?access_token=ACCESS_TOKEN";

    /**
     * 测试个性化菜单匹配结果
     */
    public final static String TRY_MATCH = WEIXIN + "/menu/trymatch?access_token=ACCESS_TOKEN";

}

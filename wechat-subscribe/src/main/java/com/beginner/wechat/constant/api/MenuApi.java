package com.beginner.wechat.constant.api;

/**
 * @author heqing
 * @date 2018/5/21.
 */
public class MenuApi extends BaseApi {

    /**
     * CREATE_MENU 创建自定义菜单
     */
    public final static String CREATE_MENU = WEIXIN + "/cgi-bin/menu/create";

    /**
     * GET_MENU 获取自定义菜单信息
     */
    public final static String GET_MENU = WEIXIN + "/cgi-bin/menu/get";

    /**
     * DEL_MENU 删除自定义菜单
     */
    public final static String DEL_MENU = WEIXIN + "/cgi-bin/menu/delete";

    /**
     * GET_MENU_CONFIG 获取自定义菜单配置信息
     */
    public final static String GET_MENU_CONFIG = WEIXIN + "/cgi-bin/get_current_selfmenu_info";

    /**
     * ADD_CONDITIONAL 创建个性化菜单
     */
    public final static String ADD_CONDITIONAL = WEIXIN + "/cgi-bin/menu/addconditional";

    /**
     * DEL_CONDITIONAL 删除个性化菜单
     */
    public final static String DEL_CONDITIONAL = WEIXIN + "/cgi-bin/menu/delconditional";

    /**
     * TRY_MATCH 测试个性化菜单匹配结果
     */
    public final static String TRY_MATCH = WEIXIN + "/cgi-bin/menu/trymatch";
}

package com.beginner.wechat.api;

/**
 * 自定义菜单，微信接口
 * @author heqing
 * @date 2018/5/21.
 */
public class MenuApi extends BaseApi {

    /**
     * CREATE_MENU 创建自定义菜单
     */
    public final static String CREATE_MENU = WEIXIN + "/menu/create?access_token=ACCESS_TOKEN";

    /**
     * GET_MENU 获取自定义菜单信息
     */
    public final static String GET_MENU = WEIXIN + "/menu/get?access_token=ACCESS_TOKEN";

    /**
     * DEL_MENU 删除自定义菜单
     */
    public final static String DEL_MENU = WEIXIN + "/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * GET_MENU_CONFIG 获取自定义菜单配置信息
     */
    public final static String GET_MENU_CONFIG = WEIXIN + "/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

    /**
     * ADD_CONDITIONAL 创建个性化菜单
     */
    public final static String ADD_CONDITIONAL = WEIXIN + "/menu/addconditional?access_token=ACCESS_TOKEN";

    /**
     * DEL_CONDITIONAL 删除个性化菜单
     */
    public final static String DEL_CONDITIONAL = WEIXIN + "/menu/delconditional?access_token=ACCESS_TOKEN";

    /**
     * TRY_MATCH 测试个性化菜单匹配结果
     */
    public final static String TRY_MATCH = WEIXIN + "/menu/trymatch?access_token=ACCESS_TOKEN";

}

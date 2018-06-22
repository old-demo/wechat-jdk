package com.beginner.wechat.api;

/**
 * 自定义菜单微信接口地址
 * @author heqing
 * @date 2018/5/21
 */
public class MenuApi extends BaseApi {

    /**
     * 自定义菜单创建接口
     */
    public final static String MENU_CREATE = WEIXIN + "/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 自定义菜单查询接口
     */
    public final static String MENU_GET = WEIXIN + "/menu/get?access_token=ACCESS_TOKEN";

    /**
     * 自定义菜单删除接口
     */
    public final static String MENU_DELETE = WEIXIN + "/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * 获取自定义菜单配置接口
     */
    public final static String MENU_GET_CURRENT_INFO = WEIXIN + "/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

    /**
     * 创建个性化菜单
     */
    public final static String MENU_ADD_CONDITIONAL = WEIXIN + "/menu/addconditional?access_token=ACCESS_TOKEN";

    /**
     * 删除个性化菜单
     */
    public final static String MENU_DEL_CONDITIONAL = WEIXIN + "/menu/delconditional?access_token=ACCESS_TOKEN";

    /**
     * 测试个性化菜单匹配结果
     */
    public final static String MENU_TRY_MATCH = WEIXIN + "/menu/trymatch?access_token=ACCESS_TOKEN";

}

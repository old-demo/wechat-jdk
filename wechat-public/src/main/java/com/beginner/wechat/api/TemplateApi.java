package com.beginner.wechat.api;

/**
 * 微信模板接口
 * @author heqing
 * @date 2018/6/4.
 */
public class TemplateApi extends BaseApi {

    /**
     * SET_Industry  设置所属行业
     */
    public final static String SET_Industry = WEIXIN + "/template/api_set_industry?access_token=ACCESS_TOKEN";

    /**
     * GET_Industry  获取设置的行业信息
     */
    public final static String GET_Industry = WEIXIN + "/template/get_industry?access_token=ACCESS_TOKEN";

    /**
     * ADD_TEMPLATE  获得模板ID
     */
    public final static String ADD_TEMPLATE = WEIXIN + "/template/api_add_template?access_token=ACCESS_TOKEN";

    /**
     * GET_ALL_TEMPLATE  获取模板列表
     */
    public final static String GET_ALL_TEMPLATE = WEIXIN + "/template/get_all_private_template?access_token=ACCESS_TOKEN";

    /**
     * DEL_TEMPLATE  删除模板
     */
    public final static String DEL_TEMPLATE = WEIXIN + "/template/del_private_template?access_token=ACCESS_TOKEN";

    /**
     * SEND_TEMPLATE  发送模板消息
     */
    public final static String SEND_TEMPLATE = WEIXIN + "/message/template/send?access_token=ACCESS_TOKEN";
}

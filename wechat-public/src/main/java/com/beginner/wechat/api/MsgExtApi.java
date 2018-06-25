package com.beginner.wechat.api;

/**
 * 模板消息管理 微信接口地址
 * @author heqing
 * @date 2018/6/3
 */
public class MsgExtApi extends MsgApi {

    /**
     * 设置所属行业
     */
    public final static String MSG_TEMPLATE_SET_INDUSTRY = WEIXIN + "/template/api_set_industry?access_token=ACCESS_TOKEN";

    /**
     * 获取设置的行业信息
     */
    public final static String MSG_TEMPLATE_GET_INDUSTRY = WEIXIN + "/template/get_industry?access_token=ACCESS_TOKEN";

    /**
     * 获得模板ID
     */
    public final static String MSG_TEMPLATE_ADD = WEIXIN + "/template/api_add_template?access_token=ACCESS_TOKEN";

    /**
     * 获取模板列表
     */
    public final static String MSG_TEMPLATE_GET_ALL = WEIXIN + "/template/get_all_private_template?access_token=ACCESS_TOKEN";

    /**
     * 删除模板
     */
    public final static String MSG_TEMPLATE_DEL = WEIXIN + "/template/del_private_template?access_token=ACCESS_TOKEN";

    /**
     * 发送模板消息
     */
    public final static String MSG_TEMPLATE_SEND = WEIXIN + "/message/template/send?access_token=ACCESS_TOKEN";

}

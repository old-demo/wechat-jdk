package com.beginner.wechat.api;

/**
 * 消息管理
 * @author heqing
 * @date 2018/6/3
 */
public class MsgApi extends BaseApi {

    /**
     * 客服管理基础接口前缀
     */
    protected final static String KF = "https://api.weixin.qq.com/customservice";

    /**
     * 获取微信服务器IP地址
     */
    public final static String MSG_GET_CALLBACK_IP = WEIXIN + "/getcallbackip?access_token=ACCESS_TOKEN";

    /**
     * 添加客服帐号
     */
    public final static String MSG_KF_ADD_ACCOUNT = KF + "/kfaccount/add?access_token=ACCESS_TOKEN";

    /**
     * 修改客服帐号
     */
    public final static String MSG_KF_UPDATE_ACCOUNT = KF + "/kfaccount/update?access_token=ACCESS_TOKEN";

    /**
     * 删除客服账号
     */
    public final static String MSG_KF_DEL_ACCOUNT = KF + "/kfaccount/del?access_token=ACCESS_TOKEN";

    /**
     * 设置客服帐号的头像
     */
    public final static String MSG_KF_UPLOAD_HEAD_IMG = KF + "/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";

    /**
     * 获取所有客服账号
     */
    public final static String MSG_KF_GET_LIST = WEIXIN + "/customservice/getkflist?access_token=ACCESS_TOKEN";

    /**
     * 客服接口-发消息
     */
    public final static String MSG_KF_SEND_MSG = WEIXIN + "/message/custom/send?access_token=ACCESS_TOKEN";

    /**
     * 客服输入状态
     */
    public final static String MSG_KF_TYPING = WEIXIN + "/message/custom/typing?access_token=ACCESS_TOKEN";

    /**
     * 根据标签进行群发【订阅号与服务号认证后均可用】
     */
    public final static String SEND_MASS_ALL_BY_TAG = WEIXIN + "/message/mass/sendall?access_token=ACCESS_TOKEN";

    /**
     * 根据标签进行群发【订阅号与服务号认证后均可用】
     */
    public final static String SEND_MASS_ALL_BY_OPENID = WEIXIN + "/message/mass/send?access_token=ACCESS_TOKEN";

    /**
     * 预览接口【订阅号与服务号认证后均可用】
     */
    public final static String PREVIEW_MASS = WEIXIN + "/message/mass/preview?access_token=ACCESS_TOKEN";

    /**
     * 删除群发【订阅号与服务号认证后均可用】
     */
    public final static String DELETE_MASS = WEIXIN + "/message/mass/delete?access_token=ACCESS_TOKEN";

    /**
     * 查询群发消息发送状态【订阅号与服务号认证后均可用】
     */
    public final static String GET_MASS = WEIXIN + "/message/mass/get?access_token=ACCESS_TOKEN";

    /**
     * 获取群发速度
     */
    public final static String GET_MASS_SPEED = WEIXIN + "/message/mass/speed/get?access_token=ACCESS_TOKEN";

    /**
     * 设置群发速度
     */
    public final static String SET_MASS_SPEED = WEIXIN + "/message/mass/speed/set?access_token=ACCESS_TOKEN";

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

    /**
     * 推送一次性订阅消息
     */
    public final static String MSG_SUBSCRIBE_TEMPLATE = WEIXIN + "/message/template/subscribe?access_token=ACCESS_TOKEN";

    /**
     * 推送一次性订阅消息
     */
    public final static String MSG_CLEAR_QUOTA = WEIXIN + "/clear_quota?access_token=ACCESS_TOKEN";

    /**
     * 获取公众号的自动回复规则
     */
    public final static String MSG_GET_AUTO_REPLY_INFO = WEIXIN + "/get_current_autoreply_info?access_token=ACCESS_TOKEN";

}

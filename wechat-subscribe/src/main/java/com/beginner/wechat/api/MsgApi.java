package com.beginner.wechat.api;

/**
 * 消息管理
 * @author heqing
 * @date 2018/6/3.
 */
public class MsgApi extends BaseApi {

    protected final static String KF = "https://api.weixin.qq.com/customservice";

    /**
     * ADD_KF_ACCOUNT 添加客服帐号
     */
    public final static String ADD_KF_ACCOUNT = KF + "/kfaccount/add?access_token=ACCESS_TOKEN";

    /**
     * UPDATE_KF_ACCOUNT 修改客服帐号
     */
    public final static String UPDATE_KF_ACCOUNT = KF + "/kfaccount/update?access_token=ACCESS_TOKEN";

    /**
     * DEL_KF_ACCOUNT 删除客服账号
     */
    public final static String DEL_KF_ACCOUNT = KF + "/kfaccount/del?access_token=ACCESS_TOKEN";

    /**
     * UPLOAD_HEAD_IMG 设置客服帐号的头像
     */
    public final static String UPLOAD_HEAD_IMG = KF + "/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";

    /**
     * GET_KF_LIST 获取所有客服账号
     */
    public final static String GET_KF_LIST = WEIXIN + "/customservice/getkflist?access_token=ACCESS_TOKEN";
}

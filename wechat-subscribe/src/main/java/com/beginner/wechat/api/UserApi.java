package com.beginner.wechat.api;

/**
 * 用户标签 微信接口地址
 * @author heqing
 * @date 2018/5/28
 */
public class UserApi extends BaseApi {

    /**
     * 创建标签
     */
    public final static String USER_CREATE_TAG = WEIXIN + "/tags/create?access_token=ACCESS_TOKEN";

    /**
     * 获取已建标签
     */
    public final static String USER_GET_TAG = WEIXIN + "/tags/get?access_token=ACCESS_TOKEN";

    /**
     * 修改标签
     */
    public final static String USER_UPDATE_TAG = WEIXIN + "/tags/update?access_token=ACCESS_TOKEN";

    /**
     * 删除标签
     */
    public final static String USER_DELETE_TAG = WEIXIN + "/tags/delete?access_token=ACCESS_TOKEN";

    /**
     * 获取标签下粉丝列表
     */
    public final static String USER_GET_FANS_BY_TAG = WEIXIN + "/user/tag/get?access_token=ACCESS_TOKEN";

    /**
     * 批量为用户打标签
     */
    public final static String USER_BATCH_TAGGING = WEIXIN + "/tags/members/batchtagging?access_token=ACCESS_TOKEN";

    /**
     * 批量为用户取消标签
     */
    public final static String USER_BATCH_UN_TAGGING = WEIXIN + "/tags/members/batchuntagging?access_token=ACCESS_TOKEN";

    /**
     * 获取用户身上的标签列表
     */
    public final static String USER_GET_ID_LIST = WEIXIN + "/tags/getidlist?access_token=ACCESS_TOKEN";

    /**
     * 设置用户备注名
     */
    public final static String USER_UPDATE_REMARK = WEIXIN + "/user/info/updateremark?access_token=ACCESS_TOKEN";

    /**
     * 获取用户列表
     */
    public final static String USER_GET_FANS = WEIXIN + "/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

}

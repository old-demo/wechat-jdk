package com.beginner.wechat.constant.api;

/**
 * 用户标签 微信地址
 * @author heqing
 * @date 2018/5/28.
 */
public class UserApi extends BaseApi {

    /**
     * CREATE_TAG 创建标签
     */
    public final static String CREATE_TAG = WEIXIN + "/tags/create?access_token=ACCESS_TOKEN";

    /**
     * GET_TAG 获取已建标签
     */
    public final static String GET_TAG = WEIXIN + "/tags/get?access_token=ACCESS_TOKEN";

    /**
     * UPDATE_TAG 修改标签
     */
    public final static String UPDATE_TAG = WEIXIN + "/tags/update?access_token=ACCESS_TOKEN";

    /**
     * DELETE_TAG 删除标签
     */
    public final static String DELETE_TAG = WEIXIN + "/tags/delete?access_token=ACCESS_TOKEN";

    /**
     * GET_FANS 获取标签下粉丝列表
     */
    public final static String GET_FANS = WEIXIN + "/user/tag/get?access_token=ACCESS_TOKEN";

    /**
     * BATCH_TAGGING  批量为用户打标签
     */
    public final static String BATCH_TAGGING = WEIXIN + "/tags/members/batchtagging?access_token=ACCESS_TOKEN";

    /**
     * BATCH_UN_TAGGING  批量为用户取消标签
     */
    public final static String BATCH_UN_TAGGING = WEIXIN + "/tags/members/batchuntagging?access_token=ACCESS_TOKEN";

    /**
     * GET_ID_LIST  获取用户身上的标签列表
     */
    public final static String GET_ID_LIST = WEIXIN + "/tags/getidlist?access_token=ACCESS_TOKEN";
}

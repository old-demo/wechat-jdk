package com.beginner.wechat.api;

/**
 * 素材，微信接口
 * @author heqing
 * @date 2018/5/24.
 */
public class MaterialApi extends BaseApi {

    /**
     * CREATE_TEMP_MATERIAL 新增临时素材
     */
    public final static String ADD_TEMP_MATERIAL = WEIXIN + "/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     * GET_TEMP_MATERIAL 获取临时素材
     */
    public final static String GET_TEMP_MATERIAL = WEIXIN + "/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    /**
     * GET_JSJDK_VOICE 获取高清语音素材
     */
    public final static String GET_JSJDK_VOICE = WEIXIN + "/media/get/jssdk?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    /**
     * ADD_NEWS 新增永久图文素材
     */
    public final static String ADD_NEWS = WEIXIN + "/material/add_news?access_token=ACCESS_TOKEN";

    /**
     * UPLOAD_IMG 上传图文消息内的图片获取URL
     */
    public final static String UPLOAD_IMG = WEIXIN + "/media/uploadimg?access_token=ACCESS_TOKEN";

    /**
     * UPLOAD_NEWS 上传图文消息素材
     */
    public final static String UPLOAD_NEWS = WEIXIN + "/media/uploadnews?access_token=ACCESS_TOKEN";

    /**
     * ADD_MATERIAL 新增永久素材
     */
    public final static String ADD_MATERIAL = WEIXIN + "/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     * GET_MATERIAL 获取永久素材
     */
    public final static String GET_MATERIAL = WEIXIN + "/material/get_material?access_token=ACCESS_TOKEN";

    /**
     * DEL_MATERIAL 删除永久素材
     */
    public final static String DEL_MATERIAL = WEIXIN + "/material/del_material?access_token=ACCESS_TOKEN";

    /**
     * UPDATE_NEWS 修改图文消息
     */
    public final static String UPDATE_NEWS = WEIXIN + "/material/update_news?access_token=ACCESS_TOKEN";


    /**
     * GET_MATERIAL_COUNT 获取素材总数
     */
    public final static String GET_MATERIAL_COUNT = WEIXIN + "/material/get_materialcount?access_token=ACCESS_TOKEN";

    /**
     * GET_MATERIAL 获取永久素材
     */
    public final static String GET_MATERIAL_LIST = WEIXIN + "/material/batchget_material?access_token=ACCESS_TOKEN";

}

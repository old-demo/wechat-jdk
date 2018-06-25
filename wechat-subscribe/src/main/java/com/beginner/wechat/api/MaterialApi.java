package com.beginner.wechat.api;

/**
 * 素材管理 微信接口地址
 * @author heqing
 * @date 2018/5/24
 */
public class MaterialApi extends BaseApi {

    /**
     * 新增临时素材
     */
    public final static String MATERIAL_ADD_TEMP = WEIXIN + "/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     * 获取临时素材
     */
    public final static String MATERIAL_GET_TEMP = WEIXIN + "/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    /**
     * 获取高清语音素材
     */
    public final static String MATERIAL_GET_JSJDK_VOICE = WEIXIN + "/media/get/jssdk?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    /**
     * 新增永久图文素材
     */
    public final static String MATERIAL_ADD_NEWS = WEIXIN + "/material/add_news?access_token=ACCESS_TOKEN";

    /**
     * 上传图文消息内的图片获取URL
     */
    public final static String MATERIAL_UPLOAD_IMG = WEIXIN + "/media/uploadimg?access_token=ACCESS_TOKEN";

    /**
     * 上传图文消息素材
     */
    public final static String MATERIAL_UPLOAD_NEWS = WEIXIN + "/media/uploadnews?access_token=ACCESS_TOKEN";

    /**
     * 上传视频
     */
    public final static String MATERIAL_UPLOAD_VIDEO = WEIXIN + "/media/uploadvideo?access_token=ACCESS_TOKEN";

    /**
     * 新增永久素材
     */
    public final static String MATERIAL_ADD = WEIXIN + "/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     * 获取永久素材
     */
    public final static String MATERIAL_GET = WEIXIN + "/material/get_material?access_token=ACCESS_TOKEN";

    /**
     * 删除永久素材
     */
    public final static String MATERIAL_DEL = WEIXIN + "/material/del_material?access_token=ACCESS_TOKEN";

    /**
     * 修改图文消息
     */
    public final static String MATERIAL_UPDATE_NEWS = WEIXIN + "/material/update_news?access_token=ACCESS_TOKEN";

    /**
     * 获取素材总数
     */
    public final static String MATERIAL_GET_COUNT = WEIXIN + "/material/get_materialcount?access_token=ACCESS_TOKEN";

    /**
     * 获取永久素材
     */
    public final static String MATERIAL_GET_LIST = WEIXIN + "/material/batchget_material?access_token=ACCESS_TOKEN";

}

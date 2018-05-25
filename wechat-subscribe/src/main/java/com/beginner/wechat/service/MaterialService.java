package com.beginner.wechat.service;

import com.beginner.wechat.constant.MediaType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.material.Material;
import com.beginner.wechat.model.material.MaterialCount;
import com.beginner.wechat.model.material.News;

import java.io.File;

/**
 * 素材接口
 * @author heqing
 * @date 2018/5/24.
 */
public interface MaterialService {

    /**
     * 新增临时素材
     *
     * @param accessToken 微信access_token
     * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file 文件
     * @return
     */
    Result<Material> addTempMaterial(String accessToken, MediaType mediaType, File file);

    /**
     * 获取临时素材
     *
     * @param accessToken 微信access_token
     * @param mediaId 媒体文件ID
     * @param filePath 文件地址
     * @return
     */
    Result<Material> getTempMaterial(String accessToken, String mediaId, String filePath);

    /**
     * 获取高清语音素材
     * 使用本接口获取从JSSDK的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。
     * 该音频比上文的临时素材获取接口（格式为amr，8K采样率）更加清晰，适合用作语音识别等对音质要求较高的业务。
     *
     * @param accessToken 微信access_token
     * @param mediaId 媒体文件ID
     * @param filePath 文件地址
     * @return
     */
    Result<Material> getJsJdkVoice(String accessToken, String mediaId, String filePath);

    /**
     * 新增永久图文素材
     *
     * @param accessToken 微信access_token
     * @param news 图文
     * @return
     */
    Result<Material> addNews(String accessToken, News news);

    /**
     * 上传图文消息内的图片获取URL
     *
     * @param accessToken 微信access_token
     * @param file 文件
     * @return
     */
    Result<Material> uploadImg(String accessToken, File file);

    /**
     * 新增类型永久素材
     *
     * @param accessToken 微信access_token
     * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file 文件
     * @param titile    素材的标题
     * @param introduction    素材的描述
     * @return
     */
    Result<Material> addMaterial(String accessToken, MediaType mediaType, File file, String titile, String introduction);

    /**
     * 获取永久素材
     *
     * @param accessToken 微信access_token
     * @param mediaId 媒体文件ID
     * @param file 保存的文件
     * @return
     */
    Result getMaterial(String accessToken, String mediaId, File file);

    /**
     * 获取素材总数
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result<MaterialCount> getMaterialCount(String accessToken);

    /**
     * 获取素材总数
     *
     * @param accessToken 微信access_token
     * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count 返回素材的数量，取值在1到20之间
     * @return
     */
    Result getMaterialList(String accessToken, MediaType type, Integer offset, Integer count);
}

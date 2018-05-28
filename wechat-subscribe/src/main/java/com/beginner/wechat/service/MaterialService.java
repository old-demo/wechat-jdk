package com.beginner.wechat.service;

import com.beginner.wechat.constant.MediaType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.material.*;

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
     * @param file 文件
     * @return 文件存放的地址
     */
    Result<String> getTempMaterial(String accessToken, String mediaId, File file);

    /**
     * 获取高清语音素材
     * 使用本接口获取从JSSDK的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。
     * 该音频比上文的临时素材获取接口（格式为amr，8K采样率）更加清晰，适合用作语音识别等对音质要求较高的业务。
     *
     * @param accessToken 微信access_token
     * @param mediaId 媒体文件ID
     * @param file 文件
     * @return
     */
    Result<Material> getJsJdkVoice(String accessToken, String mediaId, File file);

    /**
     * 上传图文消息内的图片获取URL
     *
     * @param accessToken 微信access_token
     * @param file 文件 图片仅支持jpg/png格式，大小必须在1MB以下
     * @return 上传图片的URL，可放置图文消息中使用
     */
    Result<String> uploadImg(String accessToken, File file);

    /**
     * 新增永久图文素材
     *
     * @param accessToken 微信access_token
     * @param news 图文
     * @return 媒体文件上传后，获取返回的合法media_id
     */
    Result<String> addNews(String accessToken, News news);

    /**
     * 新增类型永久素材
     *
     * @param accessToken 微信access_token
     * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file 文件
     * @param titile 素材的标题
     * @param introduction 素材的描述
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
     * 删除永久素材
     *
     * @param accessToken 微信access_token
     * @param mediaId 媒体文件ID
     * @return
     */
    Result delMaterial(String accessToken, String mediaId);

    /**
     * 修改图文消息
     *
     * @param accessToken 微信access_token
     * @param mediaId 要修改的图文消息的id （必传）
     * @param index 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0 （必传）
     * @param articles 更新后的图文信息
     * @return
     */
    Result updateNews(String accessToken, String mediaId, Integer index, Article articles);

    /**
     * 获取素材总数
     * 图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000
     *
     * @param accessToken 微信access_token
     * @return
     */
    Result<MaterialCount> getMaterialCount(String accessToken);

    /**
     * 获取素材总数
     * 获取永久素材的列表，也包含公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材
     * 临时素材无法通过本接口获取
     *
     * @param accessToken 微信access_token
     * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count 返回素材的数量，取值在1到20之间
     * @return
     */
    Result<ItemList> getMaterialList(String accessToken, MediaType type, Integer offset, Integer count);
}

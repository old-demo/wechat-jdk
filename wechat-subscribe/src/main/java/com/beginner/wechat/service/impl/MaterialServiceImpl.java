package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.common.HttpGetUtil;
import com.beginner.wechat.common.HttpPostUtil;
import com.beginner.wechat.constant.MediaType;
import com.beginner.wechat.constant.api.MaterialApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.material.Material;
import com.beginner.wechat.model.material.News;
import com.beginner.wechat.service.MaterialService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * @author heqing
 * @date 2018/5/24.
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Override
    public Result<Material> addTempMaterial(String accessToken, MediaType mediaType, File file) {
        String url = MaterialApi.ADD_TEMP_MATERIAL.replace("ACCESS_TOKEN", accessToken)
                .replace("TYPE", MediaType.getMedia(mediaType));
        JSONObject jsonObject = HttpPostUtil.sendFile(url, file);
        return new Result(jsonObject, Material.class);
    }

    @Override
    public Result getTempMaterial(String accessToken, String mediaId, String filePath) {
        String url = MaterialApi.GET_TEMP_MATERIAL.replace("ACCESS_TOKEN", accessToken)
                .replace("MEDIA_ID", mediaId);
        JSONObject jsonObject = HttpGetUtil.getTmpFile(url, filePath);
        return new Result<String>(jsonObject);
    }

    @Override
    public Result getJsJdkVoice(String accessToken, String mediaId, String filePath) {
        String url = MaterialApi.GET_JSJDK_VOICE.replace("ACCESS_TOKEN", accessToken)
                .replace("MEDIA_ID", mediaId);
        JSONObject jsonObject = HttpGetUtil.getTmpFile(url, filePath);
        return new Result<String>(jsonObject);
    }

    @Override
    public Result<Material> addNews(String accessToken, News news) {
        String url = MaterialApi.ADD_NEWS.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = HttpPostUtil.sendPost(url, JSON.toJSONString(news));
        return new Result(jsonObject, Material.class);
    }

    @Override
    public Result<Material> uploadImg(String accessToken, File file) {
        String url = MaterialApi.UPLOAD_IMG.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = HttpPostUtil.sendFile(url, file);
        return new Result(jsonObject, Material.class);
    }

    @Override
    public Result<Material> addMaterial(String accessToken, MediaType mediaType, File file, String titile, String introduction) {
        String url = MaterialApi.ADD_MATERIAL.replace("ACCESS_TOKEN", accessToken)
                .replace("TYPE", MediaType.getMedia(mediaType));
        if(mediaType == MediaType.VIDEO ) {
            if(StringUtils.isEmpty(titile) || StringUtils.isEmpty(introduction)) {
                return new Result(4100511, "缺少多媒体文件数据");
            } else {
                JSONObject jsonObject = HttpPostUtil.sendVideoFile(url, file, titile, introduction);
                return new Result(jsonObject, Material.class);
            }
        }
        JSONObject jsonObject = HttpPostUtil.sendFile(url, file);
        return new Result(jsonObject, Material.class);
    }

}

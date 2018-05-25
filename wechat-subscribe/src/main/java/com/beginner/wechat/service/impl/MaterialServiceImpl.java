package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.util.HttpGetUtil;
import com.beginner.wechat.util.HttpPostUtil;
import com.beginner.wechat.constant.MediaType;
import com.beginner.wechat.constant.api.MaterialApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.material.Material;
import com.beginner.wechat.model.material.MaterialCount;
import com.beginner.wechat.model.material.News;
import com.beginner.wechat.model.material.Video;
import com.beginner.wechat.service.MaterialService;
import com.beginner.wechat.util.FileUtil;
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
        String response = HttpPostUtil.sendFile(url, file, "", "");
        return new Result(JSONObject.parseObject(response), Material.class);
    }

    @Override
    public Result getTempMaterial(String accessToken, String mediaId, String filePath) {
        String url = MaterialApi.GET_TEMP_MATERIAL.replace("ACCESS_TOKEN", accessToken)
                .replace("MEDIA_ID", mediaId);
        String response = HttpGetUtil.getTmpFile(url, filePath);
        JSONObject json = new JSONObject();
        if(response.contains("errcode")) {
            json = JSONObject.parseObject(response);
        } else if(response.contains("video_url")) {
            json.put("errcode", 0);
            JSONObject video = JSONObject.parseObject(response);
            json.put("data", video.getString("video_url"));
        } else {
            json.put("errcode", 0);
            json.put("data", response);
        }
        return new Result<String>(json);
    }

    @Override
    public Result getJsJdkVoice(String accessToken, String mediaId, String filePath) {
        String url = MaterialApi.GET_JSJDK_VOICE.replace("ACCESS_TOKEN", accessToken)
                .replace("MEDIA_ID", mediaId);
        String response = HttpGetUtil.getTmpFile(url, filePath);
        JSONObject json = new JSONObject();
        if(response.contains("errcode")) {
            json = JSONObject.parseObject(response);
        } else if(response.contains("video_url")) {
            json.put("errcode", 0);
            JSONObject video = JSONObject.parseObject(response);
            json.put("data", video.getString("video_url"));
        } else {
            json.put("errcode", 0);
            json.put("data", response);
        }
        return new Result<String>(json);
    }

    @Override
    public Result<Material> addNews(String accessToken, News news) {
        String url = MaterialApi.ADD_NEWS.replace("ACCESS_TOKEN", accessToken);
        String response = HttpPostUtil.sendJsonRequest(url, JSON.toJSONString(news));
        return new Result(JSONObject.parseObject(response), Material.class);
    }

    @Override
    public Result<Material> uploadImg(String accessToken, File file) {
        String url = MaterialApi.UPLOAD_IMG.replace("ACCESS_TOKEN", accessToken);
        String response = HttpPostUtil.sendFile(url, file, "", "");
        return new Result(JSONObject.parseObject(response), Material.class);
    }

    @Override
    public Result<Material> addMaterial(String accessToken, MediaType mediaType, File file, String titile, String introduction) {
        String url = MaterialApi.ADD_MATERIAL.replace("ACCESS_TOKEN", accessToken)
                .replace("TYPE", MediaType.getMedia(mediaType));
        if(mediaType == MediaType.VIDEO ) {
            if(StringUtils.isEmpty(titile) || StringUtils.isEmpty(introduction)) {
                return new Result(4100511, "缺少多媒体文件数据");
            } else {
                String response = HttpPostUtil.sendFile(url, file, titile, introduction);
                return new Result(JSONObject.parseObject(response), Material.class);
            }
        }
        String response =  HttpPostUtil.sendFile(url, file, "", "");
        return new Result(JSONObject.parseObject(response), Material.class);
    }

    @Override
    public Result getMaterial(String accessToken, String mediaId, File file) {
        Result result = new Result();
        String url = MaterialApi.GET_MATERIAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("media_id", mediaId);
        String response = HttpPostUtil.sendJsonRequest(url, params.toJSONString());
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONArray newsItemList = jsonObject.getJSONArray("news_item");
        if(newsItemList != null && newsItemList.size() > 0) {
            jsonObject.put("articles", newsItemList);
            jsonObject.remove("news_item");
            result = new Result(jsonObject, News.class);
        } else if(jsonObject.getString("title") != null) {
            result = new Result(jsonObject, Video.class);
        } else {
            if(response.contains("errcode")) {
                result = new Result(JSONObject.parseObject(response));
            } else {
                FileUtil.stringToFile(response, file);
                JSONObject resultJson = new JSONObject();
                resultJson.put("errcode", 0);
                resultJson.put("data", file.getAbsolutePath());
                result = new Result(resultJson);
            }
        }
        return result;
    }

    @Override
    public Result<MaterialCount> getMaterialCount(String accessToken) {
        String url = MaterialApi.GET_MATERIAL_COUNT.replace("ACCESS_TOKEN", accessToken);
        String response =  HttpGetUtil.sendRequest(url);
        return new Result(JSONObject.parseObject(response), MaterialCount.class);
    }

    @Override
    public Result getMaterialList(String accessToken, MediaType type, Integer offset, Integer count) {
        String url = MaterialApi.GET_MATERIAL_LIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject json = new JSONObject();
        json.put("type", "image");
        json.put("offset", 0);
        json.put("count", "10");
        System.out.println("1--->"+json.toJSONString());
        String response = HttpPostUtil.sendJsonRequest(url, json.toJSONString());
        System.out.println("2--->"+response);

        return null;
    }

}

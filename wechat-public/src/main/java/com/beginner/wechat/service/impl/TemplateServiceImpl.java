package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.api.TemplateApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.SendTemplate;
import com.beginner.wechat.model.template.Template;
import com.beginner.wechat.service.TemplateService;
import com.beginner.wechat.util.HttpGetUtil;
import com.beginner.wechat.util.HttpPostUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2018/6/4.
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Override
    public Result setIndustry(String accessToken, String industryId1, String industryId2) {
        String url = TemplateApi.SET_Industry.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("industry_id1", industryId1);
        params.put("industry_id2", industryId2);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result getIndustry(String accessToken) {
        String url = TemplateApi.GET_Industry.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        if(response.getInteger("errcode") == null) {
            response.put("data", response.toJSONString());
            response.remove("primary_industry");
            response.remove("secondary_industry");
        }
        return new Result(response);
    }

    @Override
    public Result addTemplate(String accessToken, String templateIdShort) {
        String url = TemplateApi.ADD_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("template_id_short", templateIdShort);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        if(response.getInteger("errcode") != null) {
            response.put("data", response.getString("template_id"));
        }
        return new Result(response);
    }

    @Override
    public Result<List<Template>> getAllTemplate(String accessToken) {
        String url = TemplateApi.GET_ALL_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        if(response.getInteger("errcode") == null) {
            List<Template> templateList = new ArrayList<>();
            JSONArray templates = response.getJSONArray("template_list");
            for(int i=0; i<templates.size(); i++) {
                Template template = JSON.parseObject(templates.get(i).toString(), Template.class);
                templateList.add(template);
            }
            response.put("data", templateList);
        }
        return new Result(response);
    }

    @Override
    public Result delTemplate(String accessToken, String templateId) {
        String url = TemplateApi.DEL_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("template_id", templateId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result sendTemplate(String accessToken, SendTemplate sendTemplate) {
        String url = TemplateApi.SEND_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, sendTemplate);
        if(response.getInteger("errcode") != null) {
            response.put("data", response.getString("msgid"));
        }
        return new Result(response);
    }
}

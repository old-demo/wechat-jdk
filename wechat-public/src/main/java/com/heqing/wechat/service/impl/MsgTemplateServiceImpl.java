package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.api.MsgExtApi;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.message.SendTemplate;
import com.heqing.wechat.model.template.Template;
import com.heqing.wechat.service.MsgTemplateService;
import com.heqing.wechat.util.HttpGetUtil;
import com.heqing.wechat.util.HttpPostUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息模 板实现类
 * @author heqing
 * @date 2018/6/4
 */
@Service
public class MsgTemplateServiceImpl implements MsgTemplateService {

    @Override
    public Result setIndustry(String accessToken, String industryId1, String industryId2) {
        String url = MsgExtApi.MSG_TEMPLATE_SET_INDUSTRY.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("industry_id1", industryId1);
        params.put("industry_id2", industryId2);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result getIndustry(String accessToken) {
        String url = MsgExtApi.MSG_TEMPLATE_GET_INDUSTRY.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        Integer errcode = response.getInteger("errcode");
        if(errcode == null) {
            response.put("data", response.toJSONString());
        }
        return new Result(response);
    }

    @Override
    public Result getTemplateId(String accessToken, String templateIdShort) {
        String url = MsgExtApi.MSG_TEMPLATE_ADD.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("template_id_short", templateIdShort);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        String templateid = response.getString("template_id");
        if(templateid != null) {
            response.put("data", templateid);
        }
        return new Result(response);
    }

    @Override
    public Result<List<Template>> getAllTemplate(String accessToken) {
        String url = MsgExtApi.MSG_TEMPLATE_GET_ALL.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        JSONArray templateArray = response.getJSONArray("template_list");
        if(templateArray != null) {
            List<Template> templateList = new ArrayList<>();
            for(int i=0; i<templateArray.size(); i++) {
                Template template = JSON.parseObject(templateArray.get(i).toString(), Template.class);
                templateList.add(template);
            }
            response.put("data", templateList);
        }
        return new Result(response);
    }

    @Override
    public Result delTemplate(String accessToken, String templateId) {
        String url = MsgExtApi.MSG_TEMPLATE_DEL.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("template_id", templateId);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result sendTemplate(String accessToken, SendTemplate sendTemplate) {
        String url = MsgExtApi.MSG_TEMPLATE_SEND.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, sendTemplate);
        String msgId = response.getString("msgid");
        if(msgId != null) {
            response.put("data", msgId);
        }
        return new Result(response);
    }
}

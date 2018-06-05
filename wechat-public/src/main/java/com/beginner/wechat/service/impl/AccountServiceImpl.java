package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.api.AccountApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.account.QRCode;
import com.beginner.wechat.service.AccountService;
import com.beginner.wechat.util.HttpPostUtil;
import com.beginner.wechat.util.WechatFileUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heqing
 * @date 2018/6/5.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public Result<QRCode> createQRCodeTicket(String accessToken, Integer expireSeconds, String actionName, Integer sceneId, String sceneStr) {
        String url = AccountApi.CREATE_QRCODE.replace("TOKEN", accessToken);;
        Map scene = new HashMap(16);
        if(sceneId != null) {
            scene.put("scene_id", sceneId);
        }
        if(sceneStr != null) {
            scene.put("scene_str", sceneStr);
        }
        Map actionInfo = new HashMap(16);
        actionInfo.put("scene", scene);
        JSONObject params = new JSONObject();
        if(expireSeconds != null) {
            params.put("expire_seconds", expireSeconds);
        }
        params.put("action_name", actionName);
        params.put("action_info", actionInfo);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response, QRCode.class);
    }

    @Override
    public Result<String> getQRCodeByTicket(String ticket, File file) {
        String url = AccountApi.GET_QRCODE.replace("TICKET", ticket);
        JSONObject response = WechatFileUtil.getFile(url, file);
        return new Result(response);
    }

    @Override
    public Result<String> longToShort(String accessToken, String longUrl) {
        String url = AccountApi.LONG_TO_SHORT.replace("ACCESS_TOKEN", accessToken);;
        JSONObject params = new JSONObject();
        params.put("action", "long2short");
        params.put("long_url", longUrl);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());System.out.println("-->"+response.toJSONString());
        return new Result(response);
    }
}

package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.api.AccountExtApi;
import com.heqing.wechat.constant.QRType;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.account.QRCode;
import com.heqing.wechat.service.AccountExtService;
import com.heqing.wechat.util.HttpPostUtil;
import com.heqing.wechat.util.WechatFileUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 账号管理 实现类
 * @author heqing
 * @date 2018/6/5
 */
@Service
public class AccountExtServiceImpl implements AccountExtService {

    @Override
    public Result<QRCode> createQRCodeTicket(String accessToken, Integer expireSeconds, QRType qrType, Integer sceneId, String sceneStr) {
        String url = AccountExtApi.ACCOUNT_CREATE_QRCODE.replace("TOKEN", accessToken);
        Map scene = new HashMap<>(16);
        if(sceneId != null) {
            scene.put("scene_id", sceneId);
        }
        if(sceneStr != null) {
            scene.put("scene_str", sceneStr);
        }
        Map actionInfo = new HashMap<>(16);
        actionInfo.put("scene", scene);
        JSONObject params = new JSONObject();
        if(expireSeconds != null) {
            params.put("expire_seconds", expireSeconds);
        }
        params.put("action_name", qrType.getName());
        params.put("action_info", actionInfo);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response, QRCode.class);
    }

    @Override
    public Result<String> getQRCodeByTicket(String ticket, File file) {
        String url = AccountExtApi.ACCOUNT_GET_QRCODE.replace("TICKET", ticket);
        JSONObject response = WechatFileUtil.getFile(url, file);
        return new Result(response);
    }

    @Override
    public Result<String> longToShort(String accessToken, String longUrl) {
        String url = AccountExtApi.ACCOUNT_LONG_TO_SHORT.replace("ACCESS_TOKEN", accessToken);;
        JSONObject params = new JSONObject();
        params.put("action", "long2short");
        params.put("long_url", longUrl);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());System.out.println("-->"+response.toJSONString());
        return new Result(response);
    }
}

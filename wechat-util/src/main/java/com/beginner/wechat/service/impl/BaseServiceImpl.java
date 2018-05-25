package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.util.HttpGetUtil;
import com.beginner.wechat.constant.api.BaseApi;
import com.beginner.wechat.model.AccessToken;
import com.beginner.wechat.model.CallBack;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 公共方法实现类
 *
 * @author heqing
 * @date 2018/5/14
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public Result<AccessToken> getAccessToken(String appid, String secret) {
        String url = BaseApi.GET_TOKEN.replace("APPID", appid).replace("APPSECRET", secret);
        String response = HttpGetUtil.sendRequest(url);
        return new Result(JSONObject.parseObject(response), AccessToken.class);
    }

    @Override
    public Result<CallBack> listCallBackIP(String accessToken) {
        String url = BaseApi.GET_CALLBACK_IP.replace("ACCESS_TOKEN", accessToken);
        String response = HttpGetUtil.sendRequest(url);
        return new Result(JSONObject.parseObject(response), CallBack.class);
    }
}

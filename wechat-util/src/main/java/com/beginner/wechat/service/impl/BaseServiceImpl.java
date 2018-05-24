package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.common.HttpGetUtil;
import com.beginner.wechat.common.api.BaseApi;
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
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url);
        return new Result(jsonObject, AccessToken.class);
    }

    @Override
    public Result<CallBack> listCallBackIP(String accessToken) {
        String url = BaseApi.GET_CALLBACK_IP.replace("ACCESS_TOKEN", accessToken);
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url);
        return new Result(jsonObject, CallBack.class);
    }
}

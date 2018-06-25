package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.service.BaseService;
import com.beginner.wechat.util.HttpGetUtil;
import com.beginner.wechat.api.BaseApi;
import com.beginner.wechat.model.AccessToken;
import com.beginner.wechat.model.Result;
import org.springframework.stereotype.Service;

/**
 * 微信公共方法实现类
 * @author heqing
 * @date 2018/5/14
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public Result<AccessToken> getAccessToken(String appid, String secret) {
        String url = BaseApi.TOKEN_GET.replace("APPID", appid).replace("APPSECRET", secret);
        JSONObject response = HttpGetUtil.getResponse(url);
        return new Result(response, AccessToken.class);
    }
}

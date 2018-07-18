package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.service.BaseService;
import com.heqing.wechat.util.HttpGetUtil;
import com.heqing.wechat.api.BaseApi;
import com.heqing.wechat.model.AccessToken;
import com.heqing.wechat.model.Result;
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

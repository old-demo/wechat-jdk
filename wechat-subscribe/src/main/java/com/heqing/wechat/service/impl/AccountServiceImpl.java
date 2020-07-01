package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.api.AccountApi;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.account.WebAccessToken;
import com.heqing.wechat.service.AccountService;
import com.heqing.wechat.util.HttpGetUtil;
import com.heqing.wechat.util.HttpPostUtil;
import org.springframework.stereotype.Service;

/**
 * @author heqing
 * @date 2018/10/17 11:21
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public Result<WebAccessToken> getWebAccessToken(String appid, String secret, String code) {
        String url = AccountApi.GET_AUTHORIZATION_TIKEN.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
        System.out.println(url);
        JSONObject response = HttpGetUtil.getResponse(url);
        return new Result(response, WebAccessToken.class);
    }
}

package com.beginner.wechat.service.base.impl;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.common.HttpGetUtil;
import com.beginner.wechat.constant.BaseApi;
import com.beginner.wechat.model.base.AccessToken;
import com.beginner.wechat.service.base.BaseService;
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
    public AccessToken getAccessToken(String appid, String secret) {
        String url = BaseApi.GET_TOKEN;
        String param = "grant_type=client_credential&appid="+appid+"&secret="+secret;
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url, param);

        AccessToken accessToken = new AccessToken();
        accessToken.setErrcode(jsonObject.getInteger("errcode"));
        accessToken.setErrmsg(jsonObject.getString("errmsg"));
        accessToken.setAccessToken(jsonObject.getString("access_token"));
        accessToken.setExpiresIn(jsonObject.getString("expires_in"));
        return accessToken;
    }
}

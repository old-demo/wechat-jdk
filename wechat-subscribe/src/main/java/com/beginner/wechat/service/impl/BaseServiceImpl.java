package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.common.HttpGetUtil;
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
        String url = BaseApi.GET_TOKEN;
        String param = "grant_type=client_credential&appid="+appid+"&secret="+secret;
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url, param);

        Result result = new Result();
        Integer code = jsonObject.getInteger("errcode");
        if(code == null || code == 0){
            code = 0;
            result.setData(JSON.parseObject(jsonObject.toJSONString(), AccessToken.class));
        } else {
            result.setErrmsg(jsonObject.getString("errmsg"));
        }
        result.setErrcode(code);
        return result;
    }

    @Override
    public Result<CallBack> listCallBackIP(String accessToken) {
        String url = BaseApi.GET_CALLBACK_IP;
        String param = "access_token="+accessToken;
        JSONObject jsonObject = HttpGetUtil.httpGetRequest(url, param);

        Result result = new Result();
        Integer code = jsonObject.getInteger("errcode");
        if(code == null || code == 0){
            code = 0;
            result.setData(JSON.parseObject(jsonObject.toJSONString(), CallBack.class));
        } else {
            result.setErrmsg(jsonObject.getString("errmsg"));
        }
        result.setErrcode(code);
        return result;
    }
}

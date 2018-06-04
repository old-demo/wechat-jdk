package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.api.CustomerApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.KFAccount;
import com.beginner.wechat.service.CustomerService;
import com.beginner.wechat.util.HttpGetUtil;
import com.beginner.wechat.util.HttpPostUtil;
import com.beginner.wechat.util.WechatFileUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户服务
 * @author heqing
 * @date 2018/6/4.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Result addCustomerService(String accessToken, String account, String nickName, String password) {
        String url = CustomerApi.ADD_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("kf_account", account);
        params.put("nickname", nickName);
        params.put("password", password);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        System.out.println("---"+response.toJSONString());
        return new Result(response);
    }

    @Override
    public Result updateCustomerService(String accessToken, String account, String nickName, String password) {
        String url = CustomerApi.UPDATE_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("kf_account", account);
        params.put("nickname", nickName);
        params.put("password", password);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result delCustomerService(String accessToken, String account, String nickName, String password) {
        String url = CustomerApi.DEL_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("kf_account", account);
        params.put("nickname", nickName);
        params.put("password", password);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result accounteadImgUrl(String accessToken, String account, File file) {
        String url = CustomerApi.UPLOAD_HEAD_IMG.replace("ACCESS_TOKEN", accessToken)
                .replace("KFACCOUNT", account);
        JSONObject jsonSendFile = WechatFileUtil.jsonSendFile(url, file, "", "");
        return new Result(jsonSendFile);
    }

    @Override
    public Result<List<KFAccount>> listAccount(String accessToken) {
        String url = CustomerApi.GET_KF_LIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject response =  HttpGetUtil.getResponse(url);
        System.out.println("-----"+response.toJSONString());
        List<KFAccount> kfAccountList = new ArrayList<>();
        JSONArray kfList = response.getJSONArray("kf_list");
        if(kfList != null) {
            for(int i=0; i<kfList.size(); i++) {
                JSONObject ks = kfList.getJSONObject(i);
                KFAccount kfAccount = JSON.parseObject(ks.toJSONString(), KFAccount.class);
                kfAccountList.add(kfAccount);
            }
            response.put("data", kfList);
        }
        return new Result(response);
    }

}

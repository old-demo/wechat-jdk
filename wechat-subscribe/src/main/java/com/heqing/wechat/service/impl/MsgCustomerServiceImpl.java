package com.heqing.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heqing.wechat.api.MsgApi;
import com.heqing.wechat.model.Result;
import com.heqing.wechat.model.message.BaseMsg;
import com.heqing.wechat.model.message.CustomerServiceAccount;
import com.heqing.wechat.service.MsgCustomerService;
import com.heqing.wechat.util.HttpGetUtil;
import com.heqing.wechat.util.HttpPostUtil;
import com.heqing.wechat.util.WechatFileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户服务 实现类
 * @author heqing
 * @date 2018/6/4
 */
@Service
public class MsgCustomerServiceImpl implements MsgCustomerService {

    @Override
    public Result addCustomerService(String accessToken, String account, String nickName, String password) {
        String url = MsgApi.MSG_KF_ADD_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("kf_account", account);
        params.put("nickname", nickName);
        params.put("password", password);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result updateCustomerService(String accessToken, String account, String nickName, String password) {
        String url = MsgApi.MSG_KF_UPDATE_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("kf_account", account);
        params.put("nickname", nickName);
        params.put("password", password);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result delCustomerService(String accessToken, String account, String nickName, String password) {
        String url = MsgApi.MSG_KF_DEL_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("kf_account", account);
        params.put("nickname", nickName);
        params.put("password", password);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result accounteadImgUrl(String accessToken, String account, File file) {
        String url = MsgApi.MSG_KF_UPLOAD_HEAD_IMG.replace("ACCESS_TOKEN", accessToken)
                .replace("KFACCOUNT", account);
        JSONObject jsonSendFile = WechatFileUtil.jsonSendFile(url, file, "", "");
        return new Result(jsonSendFile);
    }

    @Override
    public Result<List<CustomerServiceAccount>> listAccount(String accessToken) {
        String url = MsgApi.MSG_KF_GET_LIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject response =  HttpGetUtil.getResponse(url);
        JSONArray kfList = response.getJSONArray("kf_list");
        if(kfList != null) {
            List<CustomerServiceAccount> customerServiceAccountList = new ArrayList<>();
            for(int i=0; i<kfList.size(); i++) {
                JSONObject ks = kfList.getJSONObject(i);
                CustomerServiceAccount customerServiceAccount = JSON.parseObject(ks.toJSONString(), CustomerServiceAccount.class);
                customerServiceAccountList.add(customerServiceAccount);
            }
            response.put("data", customerServiceAccountList);
        }
        return new Result(response);
    }

    @Override
    public Result sendCustomerMsg(String accessToken, String touser, String msgType, Object content, String account) {
        String url = MsgApi.MSG_KF_SEND_MSG.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("touser", touser);
        params.put("msgtype", msgType);
        params.put(msgType, content);
        if(!StringUtils.isEmpty(account)) {
            Map customservice = new HashMap<>(16);
            customservice.put("kf_account", account);
            params.put("customservice", customservice);
        }
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result typing(String accessToken, String touser, String command) {
        String url = MsgApi.MSG_KF_TYPING.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("touser", touser);
        params.put("command", command);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }
}

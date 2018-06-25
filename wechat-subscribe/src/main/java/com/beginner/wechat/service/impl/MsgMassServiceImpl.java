package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.api.MsgApi;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.service.MsgMassService;
import com.beginner.wechat.util.HttpPostUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 群发接口和原创校验 实现类
 * @author heqing
 * @date 2018/5/31
 */
@Service
public class MsgMassServiceImpl implements MsgMassService {

    @Override
    public Result sendMassAllByTag(String accessToken, boolean isToAll, int tagId, BaseMsg baseMsg, int sendIgnoreReprint, String clientMsgId) {
        JSONObject params = new JSONObject();
        Map filter = new HashMap<>(2);
        filter.put("is_to_all", isToAll);
        filter.put("tag_id", tagId);
        params.put("filter", filter);
        params.put("msgtype", baseMsg.getMsgType());
        params.put(baseMsg.getMsgType(), baseMsg.toString());
        if(MsgType.MPNEWS.getName().equals(baseMsg.getMsgType())) {
            params.put("send_ignore_reprint", sendIgnoreReprint);
        }
        if(!StringUtils.isEmpty(clientMsgId)) {
            params.put("clientmsgid", clientMsgId);
        }
        String url = MsgApi.SEND_MASS_ALL_BY_TAG.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, params);
        Map result = new HashMap(2);
        Integer msgId = response.getInteger("msg_id");
        if(msgId != null) {
            result.put("msgId", msgId);
        }
        Integer msgDataId = response.getInteger("msg_data_id");
        if(msgDataId != null) {
            result.put("msgDataId", msgDataId);
        }
        response.put("data", result);
        return new Result(response);
    }

    @Override
    public Result sendMassAllByOpenId(String accessToken, List<String> openIdList, BaseMsg baseMsg, int sendIgnoreReprint, String clientMsgId) {
        JSONObject params = new JSONObject();
        Map filter = new HashMap<>(1);
        filter.put("touser", openIdList);
        params.put("filter", filter);
        params.put("clientmsgid", clientMsgId);
        params.put("msgtype", baseMsg.getMsgType());
        params.put(baseMsg.getMsgType(), baseMsg.toString());
        if(MsgType.MPNEWS.getName().equals(baseMsg.getMsgType())) {
            params.put("send_ignore_reprint", sendIgnoreReprint);
        }
        if(!StringUtils.isEmpty(clientMsgId)) {
            params.put("clientmsgid", clientMsgId);
        }
        String url = MsgApi.SEND_MASS_ALL_BY_OPENID.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, params);
        Map result = new HashMap(2);
        Integer msgId = response.getInteger("msg_id");
        if(msgId != null) {
            result.put("msgId", msgId);
        }
        Integer msgDataId = response.getInteger("msg_data_id");
        if(msgDataId != null) {
            result.put("msgDataId", msgDataId);
        }
        response.put("data", result);
        return new Result(response);
    }

    @Override
    public Result deleteMass(String accessToken, Integer msgId, Integer articleIdx) {
        String url = MsgApi.DELETE_MASS.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_id", msgId);
        params.put("article_idx", articleIdx);
        JSONObject response = HttpPostUtil.getResponse(url, params);
        return new Result(response);
    }

    @Override
    public Result previewMassByOpenId(String accessToken, String openId, BaseMsg baseMsg) {
        return previewMass(accessToken, openId, baseMsg, 1);
    }

    @Override
    public Result previewMassByName(String accessToken, String wxName, BaseMsg baseMsg) {
        return previewMass(accessToken, wxName, baseMsg, 2);
    }

    private Result previewMass(String accessToken, String user, BaseMsg baseMsg, Integer type) {
        JSONObject params = new JSONObject();
        Map filter = new HashMap<>(1);
        if(type == 1) {
            filter.put("touser", user);
        } else {
            filter.put("towxname", user);
        }
        params.put("filter", filter);
        params.put("msgtype", baseMsg.getMsgType());
        params.put(baseMsg.getMsgType(), baseMsg.toString());
        String url = MsgApi.PREVIEW_MASS.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, params);
        Integer msgId = response.getInteger("msg_id");
        if(msgId != null) {
            response.put("data", msgId);
        }
        return new Result(response);
    }

    @Override
    public Result getMass(String accessToken, Integer msgId) {
        String url = MsgApi.GET_MASS.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("msg_id", msgId);
        JSONObject response = HttpPostUtil.getResponse(url, params);
        String msgStatus = response.getString("msg_status");
        if(msgStatus != null) {
            Map result = new HashMap(2);
            result.put("msgId", msgId);
            result.put("msg_status", msgStatus);
            response.put("data", result);
        }
        return new Result(response);
    }

    @Override
    public Result getMassSpeed(String accessToken) {
        String url = MsgApi.GET_MASS_SPEED.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, "");
        Map result = new HashMap(2);
        Integer speed = response.getInteger("speed");
        if(speed != null) {
            result.put("speed", speed);
        }
        Integer realSpeed = response.getInteger("realspeed");
        if(realSpeed != null) {
            result.put("realSpeed", realSpeed);
        }
        response.put("data", result);
        return new Result(response);
    }

    @Override
    public Result setMassSpeed(String accessToken, Integer speed) {
        String url = MsgApi.SET_MASS_SPEED.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("speed", speed);
        JSONObject response = HttpPostUtil.getResponse(url, params);
        return new Result(response);
    }
}

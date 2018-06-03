package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.api.MsgApi;
import com.beginner.wechat.constant.EventType;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.model.message.KFAccount;
import com.beginner.wechat.model.message.event.*;
import com.beginner.wechat.model.message.msg.*;
import com.beginner.wechat.service.HandlerMsgService;
import com.beginner.wechat.service.MsgService;
import com.beginner.wechat.util.*;
import com.beginner.wechat.util.aes.WXBizMsgCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heqing
 * @date 2018/6/1.
 */
@Service
public class MsgServiceImpl implements MsgService {

    @Override
    public void handlerMsg(HttpServletRequest request, HttpServletResponse response, HandlerMsgService handlerMsgService, String appid, String token, String encodingAesKey) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echoStr = request.getParameter("echostr");
            // 时间戳
            String timeStamp = request.getParameter("timestamp");

            // 阿里代码规范不让出现魔法值，只能这样写了
            String get = "GET", post = "POST", encrypt = "raw";
            PrintWriter out = response.getWriter();
            String method = request.getMethod();
            if(get.equals(method)) {
                // 微信加密签名
                String signature = request.getParameter("signature");
                // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
                if (checkSignature(token, signature, timeStamp, nonce)) {
                    out.print(echoStr);
                }
            } else if(post.equals(method)) {
                String requestXml = "";
                WXBizMsgCrypt msgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appid);
                // 安全模式
                String encryptType =request.getParameter("encrypt_type");
                // 非明文模式，对消息解密
                if (encryptType != null && !encrypt.equals(encryptType)) {
                    // 微信加密签名
                    String msgSignature = request.getParameter("msg_signature");
                    // 解密
                    String encryptMsg = StringUtil.inputSteamToString(request.getInputStream());
                    requestXml = msgCrypt.decryptMsg(msgSignature, timeStamp, nonce, encryptMsg);
                } else {
                    requestXml = StringUtil.inputSteamToString(request.getInputStream());
                }

                // 处理接收到的微信消息
                String respMessage = analysisMsg(requestXml, handlerMsgService);

                // 返回微信加密信息
                respMessage = msgCrypt.encryptMsg(respMessage, System.currentTimeMillis()+"", echoStr);
                out.print(respMessage);
            }
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkSignature(String token, String timestamp, String nonce, String signature) {
        boolean isSuccess = false;
        String tempSignature = "";
        try {
            String[] array = new String[] { token, timestamp, nonce };
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            tempSignature = hexstr.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(signature.toUpperCase().equals(tempSignature.toUpperCase())) {
            isSuccess = true;
        }
        return isSuccess;
    }

    @Override
    public String analysisMsg(String xmlStr, HandlerMsgService handlerMsgService) {
        String response = "success";
        BaseMsg baseMsg = (TextMsg) XmlUtil.stringToXml(xmlStr, TextMsg.class);
        if(MsgType.TEXT.getName().equals(baseMsg.getMsgType())) {
            // 文本消息
            response = handlerMsgService.handlerTextMsg((TextMsg) XmlUtil.stringToXml(xmlStr, TextMsg.class));
        } else if(MsgType.IMAGE.getName().equals(baseMsg.getMsgType())) {
            // 图片消息
            response = handlerMsgService.handlerImageMsg((ImageMsg) XmlUtil.stringToXml(xmlStr, ImageMsg.class));
        } else if(MsgType.VOICE.getName().equals(baseMsg.getMsgType())) {
            // 语音消息
            response = handlerMsgService.handlerVoiceMsg((VoiceMsg) XmlUtil.stringToXml(xmlStr, VoiceMsg.class));
        } else if(MsgType.VIDEO.getName().equals(baseMsg.getMsgType())) {
            // 视频消息
            response = handlerMsgService.handlerVideoMsg((VideoMsg) XmlUtil.stringToXml(xmlStr, VideoMsg.class));
        } else if(MsgType.SHORT_VIDEO.getName().equals(baseMsg.getMsgType())) {
            // 小视频消息
            response = handlerMsgService.handlerShortVideoMsg((VideoMsg) XmlUtil.stringToXml(xmlStr, VideoMsg.class));
        } else if(MsgType.LOCATION.getName().equals(baseMsg.getMsgType())) {
            // 地理位置消息
            response = handlerMsgService.handlerLocationMsg((LocationMsg) XmlUtil.stringToXml(xmlStr, LocationMsg.class));
        } else if(MsgType.LINK.getName().equals(baseMsg.getMsgType())) {
            // 链接消息
            response = handlerMsgService.handlerLinkMsg((LinkMsg) XmlUtil.stringToXml(xmlStr, LinkMsg.class));
        } else if(MsgType.EVENT.getName().equals(baseMsg.getMsgType())) {
            // 事件消息
            if(EventType.SUBSCRIBE.getName().equals(baseMsg.getEvent())) {
                // 关注事件
                response = handlerMsgService.handlerSubscribeEvent((SubscribeEvent) XmlUtil.stringToXml(xmlStr, SubscribeEvent.class));
            } else if(EventType.UN_SUBSCRIBE.getName().equals(baseMsg.getEvent())) {
                // 取消关注事件
                response = handlerMsgService.handlerUnSubscribeEvent((SubscribeEvent) XmlUtil.stringToXml(xmlStr, SubscribeEvent.class));
            } else if(EventType.SCAN.getName().equals(baseMsg.getEvent())) {
                // 扫描带参数二维码事件
                response = handlerMsgService.handlerScanEvent((ScanEvent) XmlUtil.stringToXml(xmlStr, ScanEvent.class));
            } else if(EventType.LOCATION.getName().equals(baseMsg.getEvent())) {
                // 上报地理位置事件
                response = handlerMsgService.handlerLocationEvent((LocationEvent) XmlUtil.stringToXml(xmlStr, LocationEvent.class));
            } else if(EventType.CLICK.getName().equals(baseMsg.getEvent())) {
                // 点击菜单拉取消息时的事件
                response = handlerMsgService.handlerClickEvent((MenuEvent) XmlUtil.stringToXml(xmlStr, MenuEvent.class));
            } else if(EventType.VIEW.getName().equals(baseMsg.getEvent())) {
                // 点击菜单跳转链接时的事件
                response = handlerMsgService.handlerViewEvent((MenuEvent) XmlUtil.stringToXml(xmlStr, MenuEvent.class));
            } else if(EventType.SCANCODE_PUSH.getName().equals(baseMsg.getEvent())) {
                // 扫码推事件的事件
                response = handlerMsgService.handlerScancodePushEvent((ScanEvent) XmlUtil.stringToXml(xmlStr, ScanEvent.class));
            } else if(EventType.SCANCODE_WAITMSG.getName().equals(baseMsg.getEvent())) {
                // 扫码推事件且弹出“消息接收中”提示框的事件
                response = handlerMsgService.handlerScancodeWaitmsgEvent((ScanEvent) XmlUtil.stringToXml(xmlStr, ScanEvent.class));
            } else if(EventType.PIC_SYSPHOTO.getName().equals(baseMsg.getEvent())) {
                // 弹出系统拍照发图的事件
                response = handlerMsgService.handlerPicSysphotoEvent((PicPhotoEvent) XmlUtil.stringToXml(xmlStr, PicPhotoEvent.class));
            } else if(EventType.PIC_PHOTO_OR_ALBUM.getName().equals(baseMsg.getEvent())) {
                // 弹出拍照或者相册发图的事件
                response = handlerMsgService.handlerPicPhotoOrAlbumEvent((PicPhotoEvent) XmlUtil.stringToXml(xmlStr, PicPhotoEvent.class));
            } else if(EventType.PIC_WEIXIN.getName().equals(baseMsg.getEvent())) {
                // 弹出微信相册发图器的事件
                response = handlerMsgService.handlerPicWeixinEvent((PicPhotoEvent) XmlUtil.stringToXml(xmlStr, PicPhotoEvent.class));
            } else if(EventType.LOCATION_SELECT.getName().equals(baseMsg.getEvent())) {
                // 弹出地理位置选择器的事件
                response = handlerMsgService.handlerLocationSelectEvent((LocationEvent) XmlUtil.stringToXml(xmlStr, LocationEvent.class));
            }
        }
        return response;
    }

    @Override
    public Result addCustomerService(String accessToken, String account, String nickName, String password) {
        String url = MsgApi.ADD_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
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
        String url = MsgApi.UPDATE_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("kf_account", account);
        params.put("nickname", nickName);
        params.put("password", password);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result delCustomerService(String accessToken, String account, String nickName, String password) {
        String url = MsgApi.DEL_KF_ACCOUNT.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("kf_account", account);
        params.put("nickname", nickName);
        params.put("password", password);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result accounteadImgUrl(String accessToken, String account, File file) {
        String url = MsgApi.UPLOAD_HEAD_IMG.replace("ACCESS_TOKEN", accessToken)
                .replace("KFACCOUNT", account);
        JSONObject jsonSendFile = WechatFileUtil.jsonSendFile(url, file, "", "");
        return new Result(jsonSendFile);
    }

    @Override
    public Result<List<KFAccount>> listAccount(String accessToken) {
        String url = MsgApi.GET_KF_LIST.replace("ACCESS_TOKEN", accessToken);
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
        }
        response.put("data", kfList);
        return new Result(response);
    }
}

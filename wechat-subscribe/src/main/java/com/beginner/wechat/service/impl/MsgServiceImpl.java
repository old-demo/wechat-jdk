package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.api.MsgApi;
import com.beginner.wechat.constant.EventType;
import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.AutoReplyInfo;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.model.message.SendTemplate;
import com.beginner.wechat.model.message.event.LocationEvent;
import com.beginner.wechat.model.message.event.MenuClickEvent;
import com.beginner.wechat.model.message.event.ScanEvent;
import com.beginner.wechat.model.message.event.SubscribeEvent;
import com.beginner.wechat.model.message.event.model.AuthenticationEvent;
import com.beginner.wechat.model.message.event.model.PicPhotoEvent;
import com.beginner.wechat.model.message.event.model.TemplateEvent;
import com.beginner.wechat.model.message.msg.*;
import com.beginner.wechat.service.MsgHandlerService;
import com.beginner.wechat.service.MsgService;
import com.beginner.wechat.util.*;
import com.beginner.wechat.util.aes.SHA1;
import com.beginner.wechat.util.aes.WXBizMsgCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author heqing
 * @date 2018/6/1.
 */
@Service
public class MsgServiceImpl implements MsgService {

    @Override
    public boolean checkSignature(String token, String timestamp, String nonce, String signature) {
        boolean isSuccess = false;
        String tempSignature = "";
        try {
            tempSignature =  SHA1.getSHA1(token, timestamp, nonce, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(signature.toUpperCase().equals(tempSignature.toUpperCase())) {
            isSuccess = true;
        }
        return isSuccess;
    }

    @Override
    public void handlerMsg(HttpServletRequest request, HttpServletResponse response, MsgHandlerService msgHandlerService, String appid, String token, String encodingAesKey) {
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
                String respMessage = analysisMsg(requestXml, msgHandlerService);

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
    public String analysisMsg(String xmlStr, MsgHandlerService msgHandlerService) {
        String response = "success";
        BaseMsg baseMsg = (TextMsg) XmlUtil.stringToXml(xmlStr, TextMsg.class);
        if(MsgType.TEXT.getName().equals(baseMsg.getMsgType())) {
            // 文本消息
            response = msgHandlerService.handlerTextMsg((TextMsg) XmlUtil.stringToXml(xmlStr, TextMsg.class));
        } else if(MsgType.IMAGE.getName().equals(baseMsg.getMsgType())) {
            // 图片消息
            response = msgHandlerService.handlerImageMsg((ImageMsg) XmlUtil.stringToXml(xmlStr, ImageMsg.class));
        } else if(MsgType.VOICE.getName().equals(baseMsg.getMsgType())) {
            // 语音消息
            response = msgHandlerService.handlerVoiceMsg((VoiceMsg) XmlUtil.stringToXml(xmlStr, VoiceMsg.class));
        } else if(MsgType.VIDEO.getName().equals(baseMsg.getMsgType())) {
            // 视频消息
            response = msgHandlerService.handlerVideoMsg((VideoMsg) XmlUtil.stringToXml(xmlStr, VideoMsg.class));
        } else if(MsgType.SHORT_VIDEO.getName().equals(baseMsg.getMsgType())) {
            // 小视频消息
            response = msgHandlerService.handlerShortVideoMsg((VideoMsg) XmlUtil.stringToXml(xmlStr, VideoMsg.class));
        } else if(MsgType.LOCATION.getName().equals(baseMsg.getMsgType())) {
            // 地理位置消息
            response = msgHandlerService.handlerLocationMsg((LocationMsg) XmlUtil.stringToXml(xmlStr, LocationMsg.class));
        } else if(MsgType.LINK.getName().equals(baseMsg.getMsgType())) {
            // 链接消息
            response = msgHandlerService.handlerLinkMsg((LinkMsg) XmlUtil.stringToXml(xmlStr, LinkMsg.class));
        } else if(MsgType.EVENT.getName().equals(baseMsg.getMsgType())) {
            // 事件消息
            if(EventType.SUBSCRIBE.getName().equals(baseMsg.getEventType())) {
                // 关注事件
                response = msgHandlerService.handlerSubscribeEvent((SubscribeEvent) XmlUtil.stringToXml(xmlStr, SubscribeEvent.class));
            } else if(EventType.UN_SUBSCRIBE.getName().equals(baseMsg.getEventType())) {
                // 取消关注事件
                response = msgHandlerService.handlerUnSubscribeEvent((SubscribeEvent) XmlUtil.stringToXml(xmlStr, SubscribeEvent.class));
            } else if(EventType.SCAN.getName().equals(baseMsg.getEventType())) {
                // 扫描带参数二维码事件
                response = msgHandlerService.handlerScanEvent((ScanEvent) XmlUtil.stringToXml(xmlStr, ScanEvent.class));
            } else if(EventType.LOCATION.getName().equals(baseMsg.getEventType())) {
                // 上报地理位置事件
                response = msgHandlerService.handlerLocationEvent((LocationEvent) XmlUtil.stringToXml(xmlStr, LocationEvent.class));
            } else if(EventType.MENU_CLICK.getName().equals(baseMsg.getEventType())) {
                // 点击菜单拉取消息时的事件
                response = msgHandlerService.handlerClickEvent((MenuClickEvent) XmlUtil.stringToXml(xmlStr, MenuClickEvent.class));
            } else if(EventType.MENU_VIEW.getName().equals(baseMsg.getEventType())) {
                // 点击菜单跳转链接时的事件
                response = msgHandlerService.handlerViewEvent((MenuClickEvent) XmlUtil.stringToXml(xmlStr, MenuClickEvent.class));
            } else if(EventType.SCANCODE_PUSH.getName().equals(baseMsg.getEventType())) {
                // 扫码推事件的事件
                response = msgHandlerService.handlerScancodePushEvent((ScanEvent) XmlUtil.stringToXml(xmlStr, ScanEvent.class));
            } else if(EventType.SCANCODE_WAITMSG.getName().equals(baseMsg.getEventType())) {
                // 扫码推事件且弹出“消息接收中”提示框的事件
                response = msgHandlerService.handlerScancodeWaitmsgEvent((ScanEvent) XmlUtil.stringToXml(xmlStr, ScanEvent.class));
            } else if(EventType.PIC_SYSPHOTO.getName().equals(baseMsg.getEventType())) {
                // 弹出系统拍照发图的事件
                response = msgHandlerService.handlerPicSysphotoEvent((PicPhotoEvent) XmlUtil.stringToXml(xmlStr, PicPhotoEvent.class));
            } else if(EventType.PIC_PHOTO_OR_ALBUM.getName().equals(baseMsg.getEventType())) {
                // 弹出拍照或者相册发图的事件
                response = msgHandlerService.handlerPicPhotoOrAlbumEvent((PicPhotoEvent) XmlUtil.stringToXml(xmlStr, PicPhotoEvent.class));
            } else if(EventType.PIC_WEIXIN.getName().equals(baseMsg.getEventType())) {
                // 弹出微信相册发图器的事件
                response = msgHandlerService.handlerPicWeixinEvent((PicPhotoEvent) XmlUtil.stringToXml(xmlStr, PicPhotoEvent.class));
            } else if(EventType.LOCATION_SELECT.getName().equals(baseMsg.getEventType())) {
                // 弹出地理位置选择器的事件
                response = msgHandlerService.handlerLocationSelectEvent((LocationEvent) XmlUtil.stringToXml(xmlStr, LocationEvent.class));
            }else if(EventType.TEMPLATE_SEND_JOBFINISH.getName().equals(baseMsg.getEventType())) {
                String success = "success", refuse = "failed:user block", failed = "failed: system failed";
                // 模板推送后的事件
                TemplateEvent templateEvent = (TemplateEvent) XmlUtil.stringToXml(xmlStr, TemplateEvent.class);
                if(success.equals(templateEvent.getStatus())) {
                    response = msgHandlerService.handlerSendTemplateSuccessEvent(templateEvent);
                } else if(refuse.equals(templateEvent.getStatus())) {
                    response = msgHandlerService.handlerSendTemplateRefuseEvent(templateEvent);
                } else if(failed.equals(templateEvent.getStatus())) {
                    response = msgHandlerService.handlerSendTemplateFailedEvent(templateEvent);
                }
            } else if(EventType.QUALIFICATION_VERIFY_SUCCESS.getName().equals(baseMsg.getEventType())) {
                // 资质认证成功通知
                response = msgHandlerService.handlerQualificationSuccessEvent((AuthenticationEvent) XmlUtil.stringToXml(xmlStr, AuthenticationEvent.class));
            } else if(EventType.QUALIFICATION_VERIFY_FAIL.getName().equals(baseMsg.getEventType())) {
                // 资质认证失败通知
                response = msgHandlerService.handlerQualificationFailedEvent((AuthenticationEvent) XmlUtil.stringToXml(xmlStr, AuthenticationEvent.class));
            } else if(EventType.NAMING_VERIFY_SUCCESS.getName().equals(baseMsg.getEventType())) {
                // 名称认证成功通知
                response = msgHandlerService.handlerNamingSuccessEvent((AuthenticationEvent) XmlUtil.stringToXml(xmlStr, AuthenticationEvent.class));
            } else if(EventType.NAMING_VERIFY_FAIL.getName().equals(baseMsg.getEventType())) {
                // 名称认证失败通知
                response = msgHandlerService.handlerNamingFailedEvent((AuthenticationEvent) XmlUtil.stringToXml(xmlStr, AuthenticationEvent.class));
            } else if(EventType.ANNUAL_RENEW.getName().equals(baseMsg.getEventType())) {
                // 年审通知
                response = msgHandlerService.handlerAnnualRenewEvent((AuthenticationEvent) XmlUtil.stringToXml(xmlStr, AuthenticationEvent.class));
            }
        }
        return response;
    }

    @Override
    public Result<List<String>> listCallBackIP(String accessToken) {
        String url = MsgApi.MSG_GET_CALLBACK_IP.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        JSONArray ipArray = response.getJSONArray("ip_list");
        if(ipArray != null) {
            List<String> ipList = ipArray.toJavaList(String.class);
            response.put("data", ipList);
        }
        return new Result(response);
    }

    @Override
    public Result subscribeTemplate(String accessToken, SendTemplate sendTemplate) {
        String url = MsgApi.MSG_SUBSCRIBE_TEMPLATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpPostUtil.getResponse(url, sendTemplate);
        String msgid = response.getString("msgid");
        if(msgid != null) {
            response.put("data", msgid);
        }
        return new Result(response);
    }

    @Override
    public Result clearQuota(String accessToken, String appid) {
        String url = MsgApi.MSG_CLEAR_QUOTA.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("appid", appid);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        return new Result(response);
    }

    @Override
    public Result<AutoReplyInfo> getAutoReplyInfo(String accessToken) {
        String url = MsgApi.MSG_GET_AUTO_REPLY_INFO.replace("ACCESS_TOKEN", accessToken);
        JSONObject response = HttpGetUtil.getResponse(url);
        Integer errcode = response.getInteger("errcode");
        if(errcode == null) {
            JSONObject keywordAutoreplyInfo = response.getJSONObject("keyword_autoreply_info");
            if(keywordAutoreplyInfo != null) {
                JSONArray autoreplyInfoList = keywordAutoreplyInfo.getJSONArray("list");
                for(int i=0; i<autoreplyInfoList.size(); i++) {
                    JSONObject autoreplyInfo = autoreplyInfoList.getJSONObject(i);
                    JSONArray replyListInfo = autoreplyInfo.getJSONArray("reply_list_info");
                    for(int j=0; j<replyListInfo.size(); j++) {
                        if("news".equals(replyListInfo.getJSONObject(j).getString("type"))) {
                            JSONObject newsInfo = replyListInfo.getJSONObject(j).getJSONObject("news_info");
                            replyListInfo.getJSONObject(j).put("news_info", newsInfo.getJSONArray("list"));
                        }
                    }
                }
                response.put("keyword_autoreply_info", autoreplyInfoList);
            }
        }
        return new Result(response, AutoReplyInfo.class);
    }

}

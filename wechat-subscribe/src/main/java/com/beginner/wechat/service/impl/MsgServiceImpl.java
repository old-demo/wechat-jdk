package com.beginner.wechat.service.impl;

import com.beginner.wechat.constant.MsgType;
import com.beginner.wechat.model.message.BaseMsg;
import com.beginner.wechat.model.message.msg.TextMsg;
import com.beginner.wechat.service.HandlerMsgService;
import com.beginner.wechat.service.MsgService;
import com.beginner.wechat.util.StringUtil;
import com.beginner.wechat.util.XmlUtil;
import com.beginner.wechat.util.aes.WXBizMsgCrypt;
import com.sun.java.util.jar.pack.Instruction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author heqing
 * @date 2018/6/1.
 */
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
        BaseMsg baseMsg = (BaseMsg) XmlUtil.stringToXml(xmlStr, BaseMsg.class);
        switch(baseMsg.getMsgType()) {
            case MsgType.TEXT :
                handlerMsgService.handlerTextMsg((TextMsg) XmlUtil.stringToXml(xmlStr, TextMsg.class));
                break;
            default: ;
        }
        return null;
    }
}

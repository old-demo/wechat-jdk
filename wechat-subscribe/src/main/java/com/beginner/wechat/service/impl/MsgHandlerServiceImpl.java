package com.beginner.wechat.service.impl;

import com.beginner.wechat.model.message.event.*;
import com.beginner.wechat.model.message.event.model.*;
import com.beginner.wechat.model.message.msg.*;
import com.beginner.wechat.service.MsgHandlerService;
import org.springframework.stereotype.Service;

/**
 * 处理接收到的消息实现类。开发者重写此类即可
 * @author heqing
 * @date 2018/5/31
 */
@Service
public class MsgHandlerServiceImpl implements MsgHandlerService {

    @Override
    public String handlerTextMsg(TextMsg textMsg) {
        return "success";
    }

    @Override
    public String handlerImageMsg(ImageMsg imageMsg) {
        return "success";
    }

    @Override
    public String handlerVoiceMsg(VoiceMsg voiceMsg) {
        return "success";
    }

    @Override
    public String handlerVideoMsg(VideoMsg videoMsg) {
        return "success";
    }

    @Override
    public String handlerShortVideoMsg(VideoMsg videoMsg) {
        return "success";
    }

    @Override
    public String handlerLocationMsg(LocationMsg locationMsg) {
        return "success";
    }

    @Override
    public String handlerLinkMsg(LinkMsg linkMsg) {
        return "success";
    }

    @Override
    public String handlerSubscribeEvent(SubscribeEvent subscribeEvent) {
        return "success";
    }

    @Override
    public String handlerUnSubscribeEvent(SubscribeEvent unsubscribeEvent) {
        return "success";
    }

    @Override
    public String handlerScanEvent(ScanEvent scanEvent) {
        return "success";
    }

    @Override
    public String handlerLocationEvent(LocationEvent locationEvent) {
        return "success";
    }

    @Override
    public String handlerClickEvent(MenuClickEvent clickEvent) {
        return "success";
    }

    @Override
    public String handlerViewEvent(MenuClickEvent viewEvent) {
        return "success";
    }

    @Override
    public String handlerScancodePushEvent(ScanEvent scanEvent) {
        return "success";
    }

    @Override
    public String handlerScancodeWaitmsgEvent(ScanEvent scanEvent) {
        return "success";
    }

    @Override
    public String handlerPicSysphotoEvent(PicPhotoEvent picPhotoEvent) {
        return "success";
    }

    @Override
    public String handlerPicPhotoOrAlbumEvent(PicPhotoEvent picPhotoEvent) {
        return "success";
    }

    @Override
    public String handlerPicWeixinEvent(PicPhotoEvent picPhotoEvent) {
        return "success";
    }

    @Override
    public String handlerLocationSelectEvent(LocationEvent locationEvent) {
        return "success";
    }

    @Override
    public String handlerSendTemplateSuccessEvent(TemplateEvent templateEvent) {
        return "success";
    }

    @Override
    public String handlerSendTemplateRefuseEvent(TemplateEvent templateEvent) {
        return "success";
    }

    @Override
    public String handlerSendTemplateFailedEvent(TemplateEvent templateEvent) {
        return "success";
    }

    @Override
    public String handlerQualificationSuccessEvent(AuthenticationEvent authenticationEvent) {
        return "success";
    }

    @Override
    public String handlerQualificationFailedEvent(AuthenticationEvent authenticationEvent) {
        return "success";
    }

    @Override
    public String handlerNamingSuccessEvent(AuthenticationEvent authenticationEvent) {
        return "success";
    }

    @Override
    public String handlerNamingFailedEvent(AuthenticationEvent authenticationEvent) {
        return "success";
    }

    @Override
    public String handlerAnnualRenewEvent(AuthenticationEvent authenticationEvent) {
        return "success";
    }
}

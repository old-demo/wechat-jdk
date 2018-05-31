package com.beginner.wechat.service.impl;

import com.beginner.wechat.model.message.event.*;
import com.beginner.wechat.model.message.msg.*;
import com.beginner.wechat.service.HandlerMsgService;
import org.springframework.stereotype.Service;

/**
 * @author heqing
 * @date 2018/5/31.
 */
@Service
public class HandlerMsgServiceImpl implements HandlerMsgService {


    @Override
    public String handlerTextMsg(TextMsg textMsg) {
        return null;
    }

    @Override
    public String handlerImageMsg(ImageMsg imageMsg) {
        return null;
    }

    @Override
    public String handlerVoiceMsg(VoiceMsg voiceMsg) {
        return null;
    }

    @Override
    public String handlerVideoMsg(VideoMsg videoMsg) {
        return null;
    }

    @Override
    public String handlerLocationMsg(LocationMsg locationMsg) {
        return null;
    }

    @Override
    public String handlerLinkMsg(LinkMsg linkMsg) {
        return null;
    }

    @Override
    public String handlerSubscribeEvent(SubscribeEvent subscribeEvent) {
        return null;
    }

    @Override
    public String handlerUnSubscribeEvent(SubscribeEvent unsubscribeEvent) {
        return null;
    }

    @Override
    public String handlerScanEvent(ScanEvent scanEvent) {
        return null;
    }

    @Override
    public String handlerLocationEvent(LocationEvent locationEvent) {
        return null;
    }

    @Override
    public String handlerClickEvent(MenuEvent clickEvent) {
        return null;
    }

    @Override
    public String handlerViewEvent(MenuEvent viewEvent) {
        return null;
    }

    @Override
    public String handlerScancodePushEvent(ScanEvent scanEvent) {
        return null;
    }

    @Override
    public String handlerScancodeWaitmsgEvent(ScanEvent scanEvent) {
        return null;
    }

    @Override
    public String handlerPicSysphotoEvent(PicPhotoEvent picPhotoEvent) {
        return null;
    }

    @Override
    public String handlerPicPhotoOrAlbumEvent(PicPhotoEvent picPhotoEvent) {
        return null;
    }

    @Override
    public String handlerPicWeixinEvent(PicPhotoEvent picPhotoEvent) {
        return null;
    }

    @Override
    public String handlerLocationSelectEvent(LocationEvent locationEvent) {
        return null;
    }
}

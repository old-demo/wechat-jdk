package com.beginner.wechat.model;

import com.beginner.wechat.model.message.event.SubscribeEvent;
import com.beginner.wechat.model.message.event.PicPhotoEvent;
import com.beginner.wechat.service.impl.MsgHandlerServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestMsgHandler extends MsgHandlerServiceImpl {

    @Override
    public String handlerSubscribeEvent(SubscribeEvent subscribeEvent) {
        return "11111";
    }

    @Override
    public String handlerUnSubscribeEvent(SubscribeEvent unsubscribeEvent) {
        return "2222";
    }

    @Override
    public String handlerPicWeixinEvent(PicPhotoEvent picPhotoEvent) {
        return "success111";
    }
}

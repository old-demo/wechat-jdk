package com.heqing.wechat.model;

import com.heqing.wechat.model.message.event.SubscribeEvent;
import com.heqing.wechat.model.message.event.PicPhotoEvent;
import com.heqing.wechat.service.impl.MsgHandlerServiceImpl;
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

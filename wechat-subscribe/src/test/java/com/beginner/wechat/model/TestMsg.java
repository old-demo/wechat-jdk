package com.beginner.wechat.model;

import com.beginner.wechat.model.message.event.PicPhotoEvent;
import com.beginner.wechat.service.impl.HandlerMsgServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestMsg extends HandlerMsgServiceImpl {

    @Override
    public String handlerPicWeixinEvent(PicPhotoEvent picPhotoEvent) {
        return "success111";
    }
}

package com.beginner.wechat.service;

import com.beginner.wechat.model.message.event.*;
import com.beginner.wechat.model.message.event.model.*;
import com.beginner.wechat.model.message.msg.*;

/**
 * 处理接收到的消息 接口
 * @author heqing
 * @date 2018/5/31
 */
public interface MsgHandlerService {

    /**
     * 处理文本消息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453">微信文档--普通消息</a>
     * @param textMsg 文本消息
     * @return 返回消息
     */
    String handlerTextMsg(TextMsg textMsg);

    /**
     * 处理图片消息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453">微信文档--普通消息</a>
     * @param imageMsg 图片消息
     * @return
     */
    String handlerImageMsg(ImageMsg imageMsg);

    /**
     * 处理语音消息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453">微信文档--普通消息</a>
     * @param voiceMsg 语音消息
     * @return
     */
    String handlerVoiceMsg(VoiceMsg voiceMsg);

    /**
     * 处理视频消息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453">微信文档--普通消息</a>
     * @param videoMsg 视频消息
     * @return
     */
    String handlerVideoMsg(VideoMsg videoMsg);

    /**
     * 处理小视频消息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453">微信文档--普通消息</a>
     * @param videoMsg 视频消息
     * @return
     */
    String handlerShortVideoMsg(VideoMsg videoMsg);

    /**
     * 处理地理位置消息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453">微信文档--普通消息</a>
     * @param locationMsg 地理位置消息
     * @return
     */
    String handlerLocationMsg(LocationMsg locationMsg);

    /**
     * 处理链接消息
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140453">微信文档--普通消息</a>
     * @param linkMsg 链接消息
     * @return
     */
    String handlerLinkMsg(LinkMsg linkMsg);

    /**
     * 处理关注事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454">微信文档--事件消息</a>
     * @param subscribeEvent 关注事件
     * @return
     */
    String handlerSubscribeEvent(SubscribeEvent subscribeEvent);

    /**
     * 处理取消关注事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454">微信文档--事件消息</a>
     * @param unsubscribeEvent 取消关注事件
     * @return
     */
    String handlerUnSubscribeEvent(SubscribeEvent unsubscribeEvent);

    /**
     * 处理扫描带参数二维码事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454">微信文档--事件消息</a>
     * @param scanCodeEvent 扫描带参数二维码事件
     * @return
     */
    String handlerScanEvent(ScanCodeEvent scanCodeEvent);

    /**
     * 处理上报地理位置事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454">微信文档--事件消息</a>
     * @param locationEvent 上报地理位置事件
     * @return
     */
    String handlerLocationEvent(LocationEvent locationEvent);

    /**
     * 处理点击菜单拉取消息时的事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454">微信文档--事件消息</a>
     * @param clickEvent 点击菜单拉取消息时的事件
     * @return
     */
    String handlerClickEvent(MenuEvent clickEvent);

    /**
     * 处理点击菜单跳转链接时的事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140454">微信文档--事件消息</a>
     * @param viewEvent 点击菜单跳转链接时的事件
     * @return
     */
    String handlerViewEvent(MenuEvent viewEvent);

    /**
     * 处理扫码推事件的事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141016">微信文档--自定义菜单事件推送</a>
     * @param scanCodeEvent 扫码推事件的事件
     * @return
     */
    String handlerScancodePushEvent(ScanCodeEvent scanCodeEvent);

    /**
     * 处理扫码推事件且弹出“消息接收中”提示框的事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141016">微信文档--自定义菜单事件推送</a>
     * @param scanCodeEvent 扫码推事件且弹出“消息接收中”提示框的事件
     * @return
     */
    String handlerScancodeWaitmsgEvent(ScanCodeEvent scanCodeEvent);

    /**
     * 处理弹出系统拍照发图的事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141016">微信文档--自定义菜单事件推送</a>
     * @param picPhotoEvent 弹出系统拍照发图的事件
     * @return
     */
    String handlerPicSysphotoEvent(PicPhotoEvent picPhotoEvent);

    /**
     * 处理弹出拍照或者相册发图的事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141016">微信文档--自定义菜单事件推送</a>
     * @param picPhotoEvent 弹出拍照或者相册发图的事件
     * @return
     */
    String handlerPicPhotoOrAlbumEvent(PicPhotoEvent picPhotoEvent);

    /**
     * 处理弹出微信相册发图器的事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141016">微信文档--自定义菜单事件推送</a>
     * @param picPhotoEvent 弹出微信相册发图器的事件
     * @return
     */
    String handlerPicWeixinEvent(PicPhotoEvent picPhotoEvent);

    /**
     * 处理弹出地理位置选择器的事件
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141016">微信文档--自定义菜单事件推送</a>
     * @param locationEvent 弹出地理位置选择器的事件
     * @return
     */
    String handlerLocationSelectEvent(LocationEvent locationEvent);

    /**
     * 在模版消息发送任务完成后，成功通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277">微信文档--模板消息接口</a>
     * @param templateEvent 模板事件
     * @return
     */
    String handlerSendTemplateSuccessEvent(TemplateEvent templateEvent);

    /**
     * 在模版消息发送任务完成后，用户拒绝通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277">微信文档--模板消息接口</a>
     * @param templateEvent 模板事件
     * @return
     */
    String handlerSendTemplateRefuseEvent(TemplateEvent templateEvent);

    /**
     * 在模版消息发送任务完成后，未知原因失败通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277">微信文档--模板消息接口</a>
     * @param templateEvent 模板事件
     * @return
     */
    String handlerSendTemplateFailedEvent(TemplateEvent templateEvent);

    /**
     * 资质认证成功通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455785130">微信文档--微信认证事件推送</a>
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerQualificationSuccessEvent(AuthenticationEvent authenticationEvent);

    /**
     * 资质认证失败通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455785130">微信文档--微信认证事件推送</a>
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerQualificationFailedEvent(AuthenticationEvent authenticationEvent);

    /**
     * 名称认证成功通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455785130">微信文档--微信认证事件推送</a>
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerNamingSuccessEvent(AuthenticationEvent authenticationEvent);

    /**
     * 名称认证失败通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455785130">微信文档--微信认证事件推送</a>
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerNamingFailedEvent(AuthenticationEvent authenticationEvent);

    /**
     * 年审通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455785130">微信文档--微信认证事件推送</a>
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerAnnualRenewEvent(AuthenticationEvent authenticationEvent);

    /**
     * 认证过期失效通知审通知
     * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1455785130">微信文档--微信认证事件推送</a>
     * @param authenticationEvent 认证事件
     * @return
     */
    String handlerVerifyExpiredEvent(AuthenticationEvent authenticationEvent);
}

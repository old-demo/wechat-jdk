package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.message.SendTemplate;
import com.beginner.wechat.model.template.Template;

import java.util.List;

/**
 * 消息模板 接口
 * @see <a href="https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277">微信文档-模板消息接口</a>
 * @author heqing
 * @date 2018/6/4
 */
public interface MsgTemplateService {

    /**
     * 设置所属行业
     * @param accessToken 微信access_token
     * @param industryId1 公众号模板消息所属行业编号
     * @param industryId2 公众号模板消息所属行业编号
     * @return 微信返回结果
     */
    Result setIndustry(String accessToken, String industryId1, String industryId2);

    /**
     * 获取设置的行业信息
     * @param accessToken 微信access_token
     * @return 微信返回结果
     */
    Result getIndustry(String accessToken);

    /**
     * 获得模板ID
     * @param accessToken 微信access_token
     * @param templateIdShort 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return 微信返回结果
     */
    Result getTemplateId(String accessToken, String templateIdShort);

    /**
     * 获取模板列表
     * @param accessToken 微信access_token
     * @return 模板列表
     */
    Result<List<Template>> getAllTemplate(String accessToken);

    /**
     * 获得模板ID
     * @param accessToken 微信access_token
     * @param templateId 公众帐号下模板消息ID
     * @return 微信返回结果
     */
    Result delTemplate(String accessToken, String templateId);

    /**
     * 发送模板消息
     * @param accessToken 微信access_token
     * @param sendTemplate 模板消息
     * @return 微信返回结果
     */
    Result sendTemplate(String accessToken, SendTemplate sendTemplate);
}

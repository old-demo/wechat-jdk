package com.beginner.wechat.service;

import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.statistics.InterfaceAnalysis;
import com.beginner.wechat.model.statistics.MsgAnalysis;
import com.beginner.wechat.model.statistics.NewsAnalysis;
import com.beginner.wechat.model.statistics.UserAnalysis;

import java.util.List;

/**
 * 数据统计
 *
 * @author heqing
 * @date 2018/6/5.
 */
public interface StatisticsService {

    /**
     * 获取用户增减数据（最大时间跨度：7）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<UserAnalysis>> getUserSummary(String accessToken, String beginDate, String endDate);

    /**
     * 获取累计用户数据（最大时间跨度：7）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<UserAnalysis>> getUserCumulate(String accessToken, String beginDate, String endDate);

    /**
     * 获取图文群发每日数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<NewsAnalysis>> getArticleSummary(String accessToken, String beginDate, String endDate);

    /**
     * 获取图文群发总数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<NewsAnalysis>> getArticletotal(String accessToken, String beginDate, String endDate);

    /**
     * 获取图文统计数据（最大时间跨度：3）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<NewsAnalysis>> getUserRead(String accessToken, String beginDate, String endDate);

    /**
     * 获取图文统计分时数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<NewsAnalysis>> getUserReadHour(String accessToken, String beginDate, String endDate);

    /**
     * 获取图文分享转发数据（最大时间跨度：7）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<NewsAnalysis>> getUerShare(String accessToken, String beginDate, String endDate);

    /**
     * 获取图文分享转发分时数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<NewsAnalysis>> getUserShareHour(String accessToken, String beginDate, String endDate);

    /**
     * 获取消息发送概况数据（最大时间跨度：7）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<MsgAnalysis>> getUpStreamMsg(String accessToken, String beginDate, String endDate);

    /**
     * 获取消息分送分时数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<MsgAnalysis>> getUpStreamMsgHour(String accessToken, String beginDate, String endDate);

    /**
     * 获取消息发送周数据（最大时间跨度：30）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<MsgAnalysis>> getUpStreamMsgWeek(String accessToken, String beginDate, String endDate);

    /**
     * 获取消息发送月数据（最大时间跨度：30）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<MsgAnalysis>> getUpStreamMsgMonth(String accessToken, String beginDate, String endDate);

    /**
     * 获取消息发送分布数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<MsgAnalysis>> getUpStreamMsgDist(String accessToken, String beginDate, String endDate);

    /**
     * 获取消息发送分布周数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<MsgAnalysis>> getUpStreamMsgDistWeek(String accessToken, String beginDate, String endDate);

    /**
     * 获取消息发送分布月数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<MsgAnalysis>> getUpStreamMsgDistMonth(String accessToken, String beginDate, String endDate);

    /**
     * 获取接口分析数据（最大时间跨度：30）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<InterfaceAnalysis>> getinterfaceSummary(String accessToken, String beginDate, String endDate);

    /**
     * 获取接口分析分时数据（最大时间跨度：1）
     *
     * @param accessToken 微信access_token
     * @param beginDate 获取数据的起始日期，begin_date和end_date的差值需小于“最大时间跨度”
     *       （比如最大时间跨度为1时，begin_date和end_date的差值只能为0，才能小于1），否则会报错
     * @param endDate 获取数据的结束日期，end_date允许设置的最大值为昨日
     * @return
     */
    Result<List<InterfaceAnalysis>> getInterfacesSummaryHour(String accessToken, String beginDate, String endDate);

}

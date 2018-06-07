package com.beginner.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.beginner.wechat.api.StatisticsApi;
import com.beginner.wechat.model.Result;
import com.beginner.wechat.model.statistics.InterfaceAnalysis;
import com.beginner.wechat.model.statistics.MsgAnalysis;
import com.beginner.wechat.model.statistics.NewsAnalysis;
import com.beginner.wechat.model.statistics.UserAnalysis;
import com.beginner.wechat.service.StatisticsService;
import com.beginner.wechat.util.HttpPostUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据统计
 *
 * @author heqing
 * @date 2018/6/5.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Override
    public Result<List<UserAnalysis>> getUserSummary(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_USER_SUMMARY.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        userAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<UserAnalysis>> getUserCumulate(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_USER_CUMULATE.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        userAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<NewsAnalysis>> getArticleSummary(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_ARTICLE_SUMMARY.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        mewsAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<NewsAnalysis>> getArticletotal(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_ARTICLE_TOTAL.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        mewsAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<NewsAnalysis>> getUserRead(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_USER_READ.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        mewsAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<NewsAnalysis>> getUserReadHour(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_USER_READ_HOUR.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        mewsAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<NewsAnalysis>> getUerShare(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_USER_SHARE.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        mewsAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<NewsAnalysis>> getUserShareHour(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_USER_SHARE_HOUR.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        mewsAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<MsgAnalysis>> getUpStreamMsg(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_UPSTREAM_MSG.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        msgAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<MsgAnalysis>> getUpStreamMsgHour(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_UPSTREAM_MSG_HOUR.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        msgAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<MsgAnalysis>> getUpStreamMsgWeek(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_UPSTREAM_MSG_WEEK.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        msgAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<MsgAnalysis>> getUpStreamMsgMonth(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_UPSTREAM_MSG_MONTH.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        msgAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<MsgAnalysis>> getUpStreamMsgDist(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_UPSTREAM_MSG_DIST.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        msgAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<MsgAnalysis>> getUpStreamMsgDistWeek(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_UPSTREAM_MSG_DIST_WEEK.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        msgAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<MsgAnalysis>> getUpStreamMsgDistMonth(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_UPSTREAM_MSG_DIST_MONTH.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        msgAnalysis(response);
        return new Result(response);
    }

    @Override
    public Result<List<InterfaceAnalysis>> getinterfaceSummary(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_INTERFACES_SUMMARY.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        interfaceAnalyses(response);
        return new Result(response);
    }

    @Override
    public Result<List<InterfaceAnalysis>> getInterfacesSummaryHour(String accessToken, String beginDate, String endDate) {
        String url = StatisticsApi.GET_INTERFACES_SUMMARY_HOUR.replace("ACCESS_TOKEN", accessToken);
        JSONObject params = new JSONObject();
        params.put("begin_date", beginDate);
        params.put("end_date", endDate);
        JSONObject response = HttpPostUtil.getResponse(url, params.toJSONString());
        interfaceAnalyses(response);
        return new Result(response);
    }

    private void userAnalysis(JSONObject response) {
        List<UserAnalysis> userAnalysisList = new ArrayList<>();
        JSONArray userAnalysisArray = response.getJSONArray("list");
        if(userAnalysisArray != null) {
            for(int i=0; i<userAnalysisArray.size(); i++) {
                UserAnalysis userAnalyses = JSON.parseObject(userAnalysisArray.getJSONObject(i).toJSONString(), UserAnalysis.class);
                userAnalysisList.add(userAnalyses);
            }
            response.put("data", userAnalysisList);
        }
    }

    private void mewsAnalysis(JSONObject response) {
        List<NewsAnalysis> newsAnalysisList = new ArrayList<>();
        JSONArray newsAnalysisArray = response.getJSONArray("list");
        if(newsAnalysisArray != null) {
            for(int i=0; i<newsAnalysisArray.size(); i++) {
                NewsAnalysis newAnalyses = JSON.parseObject(newsAnalysisArray.getJSONObject(i).toJSONString(), NewsAnalysis.class);
                newsAnalysisList.add(newAnalyses);
            }
            response.put("data", newsAnalysisList);
        }
    }

    private void msgAnalysis(JSONObject response) {
        List<MsgAnalysis> msgAnalysisList = new ArrayList<>();
        JSONArray msgAnalysisArray = response.getJSONArray("list");
        if(msgAnalysisArray != null) {
            for(int i=0; i<msgAnalysisArray.size(); i++) {
                MsgAnalysis newAnalyses = JSON.parseObject(msgAnalysisArray.getJSONObject(i).toJSONString(), MsgAnalysis.class);
                msgAnalysisList.add(newAnalyses);
            }
            response.put("data", msgAnalysisList);
        }
    }

    private void interfaceAnalyses(JSONObject response) {
        List<InterfaceAnalysis> interfaceAnalysesList = new ArrayList<>();
        JSONArray interfaceAnalysesArray = response.getJSONArray("list");
        if(interfaceAnalysesList != null) {
            for(int i=0; i<interfaceAnalysesList.size(); i++) {
                InterfaceAnalysis newAnalyses = JSON.parseObject(interfaceAnalysesArray.getJSONObject(i).toJSONString(), InterfaceAnalysis.class);
                interfaceAnalysesList.add(newAnalyses);
            }
            response.put("data", interfaceAnalysesList);
        }
    }

}

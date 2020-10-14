package com.shgx.mockito.action;

import com.google.common.collect.Maps;
import com.shgx.mockito.engine.NewsCheckEngine;
import com.shgx.mockito.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 新闻信息校验入口
 *
 * @author: guangxush
 * @create: 2020/09/28
 */
@Service
public class NewsCheckAction extends AbstractNewsCheckAction{

    /** 新闻信息校验引擎 */
    @Autowired
    private NewsCheckEngine newsCheckEngine;

    @Override
    public ActionResult doAction(NewsBaseServiceCtx ctx) {
        // 1. 初始化返回结果
        ActionResult actionResult = new ActionResult();
        Map<ResultCodeEnum, String> extendInfos = Maps.newHashMap();
        actionResult.setExtendInfo(extendInfos);

        // 2. 构造引擎核对上下文
        NewsBaseServiceCtx newsBaseServiceCtx = ctx;
        newsBaseServiceCtx.setEngine("inner");

        // 3. 执行校验逻辑
        BaseServiceResult result = newsCheckEngine.execute(newsBaseServiceCtx);

        // 4. 返回校验结果
        Map<String, Result> map = result.getResultMap();
        for (String code : map.keySet()) {
            extendInfos.put(map.get(code).getResultCodeEnum(), code);
        }

        return actionResult;
    }

    @Override
    public String actionCode() {
        return "NewsCheckAction";
    }
}

package com.shgx.mockito.engine;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.shgx.mockito.action.AbstractNewsCheckAction;
import com.shgx.mockito.model.BaseServiceResult;
import com.shgx.mockito.model.NewsBaseServiceCtx;
import com.shgx.mockito.model.Result;
import com.shgx.mockito.model.ResultCodeEnum;
import com.shgx.mockito.rule.AbstractBaseRule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *
 * @author: guangxush
 * @create: 2020/09/27
 */
@Component
public class NewsCheckEngine implements RuleEngine<NewsBaseServiceCtx, BaseServiceResult>{

    /**
     * 规则装配类
     */
    private RuleCheckAssembler ruleCheckAssembler;

    /**
     * 引擎可以执行的动作集合
     */
    private List<AbstractNewsCheckAction> newsActionList = Lists.newArrayList();

    @Override
    public BaseServiceResult execute(NewsBaseServiceCtx context) {
        final BaseServiceResult checkResult = new BaseServiceResult(true, ResultCodeEnum.SUCCESS.getCode());
        Map<String, Result> resultMap = Maps.newHashMap();
        // 根据条件筛选要执行的规则
        List<AbstractBaseRule> rules = ruleCheckAssembler.loadRules(context);

        for(AbstractBaseRule rule : rules){
            Result result = rule.analyze(context);
            resultMap.put(rule.getCode(), result);
        }
        checkResult.setResultMap(resultMap);
        return checkResult;
    }

    @Override
    public boolean checkContext(NewsBaseServiceCtx context) {
        return false;
    }

    public RuleCheckAssembler getRuleCheckAssembler() {
        return ruleCheckAssembler;
    }

    public void setRuleCheckAssembler(RuleCheckAssembler ruleCheckAssembler) {
        this.ruleCheckAssembler = ruleCheckAssembler;
    }

    public List<AbstractNewsCheckAction> getNewsActionList() {
        return newsActionList;
    }

    public void setNewsActionList(List<AbstractNewsCheckAction> newsActionList) {
        this.newsActionList = newsActionList;
    }
}

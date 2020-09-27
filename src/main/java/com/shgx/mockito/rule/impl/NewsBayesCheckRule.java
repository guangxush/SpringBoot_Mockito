package com.shgx.mockito.rule.impl;

import com.shgx.mockito.model.NewsBaseServiceCtx;
import com.shgx.mockito.rule.AbstractBaseRule;
import com.shgx.mockito.service.impl.BayesAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: guangxush
 * @create: 2020/09/28
 */
@Component
public class NewsBayesCheckRule extends AbstractBaseRule {

    @Autowired
    private BayesAlgorithm bayesAlgorithm;

    @Override
    public String check(NewsBaseServiceCtx context) {
        String message = context.getMessage();
        if(bayesAlgorithm.useModel(message)){
            return "";
        }
        return "属于负面新闻";
    }

    @Override
    public String getCondition() {
        return "topic==\"play\"";
    }

    @Override
    public String getCode() {
        return "NewsBayesCheckRule";
    }
}

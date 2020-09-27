package com.shgx.mockito.rule.impl;

import com.shgx.mockito.model.NewsBaseServiceCtx;
import com.shgx.mockito.rule.AbstractBaseRule;
import com.shgx.mockito.service.impl.LSTMAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: guangxush
 * @create: 2020/09/28
 */
public class NewsLSTMCheckRule extends AbstractBaseRule {

    @Autowired
    private LSTMAlgorithm lstmAlgorithm;

    @Override
    public String check(NewsBaseServiceCtx context) {
        String message = context.getMessage();
        if(lstmAlgorithm.useModel(message)){
            return "";
        }
        return "属于负面新闻";
    }

    @Override
    public String getCondition() {
        return "topic==\"music\"";
    }

    @Override
    public String getCode() {
        return "NewsLSTMCheckRule";
    }
}


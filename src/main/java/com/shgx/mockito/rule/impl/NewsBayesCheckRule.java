package com.shgx.mockito.rule.impl;

import com.shgx.mockito.model.AlgorithmDO;
import com.shgx.mockito.model.NewsBaseServiceCtx;
import com.shgx.mockito.rule.AbstractBaseRule;
import com.shgx.mockito.service.impl.BayesAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 贝叶斯校验
 *
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
        AlgorithmDO algorithmDO = new AlgorithmDO();
        algorithmDO.setParam(message);
        algorithmDO.setId("123");
        algorithmDO.setVersion("V0.1");
        if(bayesAlgorithm.useModel(algorithmDO)){
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

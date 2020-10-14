package com.shgx.mockito.rule.impl;

import com.shgx.mockito.model.NewsBaseServiceCtx;
import com.shgx.mockito.rule.AbstractBaseRule;
import com.shgx.mockito.service.impl.CNNAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 卷积神经网络校验
 *
 * @author: guangxush
 * @create: 2020/09/28
 */
@Component
public class NewsCNNCheckRule extends AbstractBaseRule {
    @Autowired
    private CNNAlgorithm cnnAlgorithm;

    @Override
    public String check(NewsBaseServiceCtx context) {
        String message = context.getMessage();
        if (cnnAlgorithm.useModel(message)) {
            return "";
        }
        return "属于负面新闻";
    }

    @Override
    public String getCondition() {
        return "topic==\"fun\"";
    }

    @Override
    public String getCode() {
        return "NewsCNNCheckRule";
    }
}

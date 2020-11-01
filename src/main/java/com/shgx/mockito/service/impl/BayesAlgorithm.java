package com.shgx.mockito.service.impl;

import com.shgx.mockito.dal.BayesAlgorithmDAL;
import com.shgx.mockito.model.AlgorithmDO;
import com.shgx.mockito.service.AbstractAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 贝叶斯算法
 *
 * @author: guangxush
 * @create: 2020/09/28
 */
@Service
public class BayesAlgorithm extends AbstractAlgorithm {

    @Autowired
    private BayesAlgorithmDAL bayesAlgorithmDAL;

    @Override
    public void buildMode(AlgorithmDO algorithm) {

    }

    @Override
    public boolean useModel(AlgorithmDO algorithm) {
        return bayesAlgorithmDAL.findResultByKey(algorithm.getId());
    }
}

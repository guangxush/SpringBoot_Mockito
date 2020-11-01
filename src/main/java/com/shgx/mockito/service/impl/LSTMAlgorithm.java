package com.shgx.mockito.service.impl;

import com.shgx.mockito.model.AlgorithmDO;
import com.shgx.mockito.service.AbstractAlgorithm;
import org.springframework.stereotype.Service;

/**
 * LSTM算法
 *
 * @author: guangxush
 * @create: 2020/09/28
 */
@Service
public class LSTMAlgorithm extends AbstractAlgorithm {
    @Override
    public void buildMode(AlgorithmDO algorithm) {

    }

    @Override
    public boolean useModel(AlgorithmDO algorithm) {
        return true;
    }
}
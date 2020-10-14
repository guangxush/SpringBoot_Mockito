package com.shgx.mockito.service.impl;

import com.shgx.mockito.service.AbstractAlgorithm;
import org.springframework.stereotype.Service;

/**
 * CNN算法
 *
 * @author: guangxush
 * @create: 2020/09/28
 */
@Service
public class CNNAlgorithm extends AbstractAlgorithm {
    @Override
    public void buildMode() {

    }

    @Override
    public boolean useModel(String input) {
        return true;
    }
}

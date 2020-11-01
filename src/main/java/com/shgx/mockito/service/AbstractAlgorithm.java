package com.shgx.mockito.service;


import com.shgx.mockito.model.AlgorithmDO;

/**
 * 抽象算法模型
 *
 * @author: guangxush
 * @create: 2020/09/28
 */
public abstract class AbstractAlgorithm {
    /**
     * 训练模型
     */
    public void trainModel(AlgorithmDO algorithm) {
    }

    /**
     * 测试模型
     */
    public void testModel(AlgorithmDO algorithmDO) {
    }

    /**
     * 构建模型
     */
    public abstract void buildMode(AlgorithmDO algorithm);

    /**
     * 使用模型
     * @param algorithm
     * @return
     */
    public abstract boolean useModel(AlgorithmDO algorithm);
}

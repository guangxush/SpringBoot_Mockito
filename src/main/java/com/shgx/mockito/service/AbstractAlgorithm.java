package com.shgx.mockito.service;


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
    public void trainModel(String input) {
    }

    /**
     * 测试模型
     */
    public void testModel(String input) {
    }

    /**
     * 构建模型
     */
    public abstract void buildMode();

    /**
     * 使用模型
     * @param input
     * @return
     */
    public abstract boolean useModel(String input);
}

package com.shgx.mockito.rule;

import com.shgx.mockito.model.BaseServiceCtx;
import com.shgx.mockito.model.Result;

/**
 * 基本规则
 *
 * @author: guangxush
 * @create: 2020/09/26
 */
public interface BaseRule<T extends BaseServiceCtx> {

    /**
     * 规则码
     *
     * @return
     */
    String getCode();

    /**
     * 新闻分析接口
     *
     * @param context
     * @return
     */
    Result analyze(T context);

}

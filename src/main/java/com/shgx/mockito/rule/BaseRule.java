package com.shgx.mockito.rule;

import com.shgx.mockito.model.BaseServiceCtx;

/**
 * @author: guangxush
 * @create: 2020/09/26
 */
public interface BaseRule<T extends BaseServiceCtx> {

    /**
     * 规则码
     * @return
     */
    String getCode();


}

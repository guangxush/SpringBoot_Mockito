package com.shgx.mockito.engine;

import com.shgx.mockito.model.NewsBaseServiceCtx;
import org.apache.commons.jexl3.JexlContext;

/**
 * Jexl参数设置器
 *
 * @author: guangxush
 * @create: 2020/09/27
 */
public interface JexlParamSetter {
    /**
     * 设置Jexl变量
     *
     * @param contextParam
     * @param context
     */
    void setJexlContextParam(NewsBaseServiceCtx contextParam, JexlContext context);
}

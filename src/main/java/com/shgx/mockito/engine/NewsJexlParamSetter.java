package com.shgx.mockito.engine;

import com.shgx.mockito.model.NewsBaseServiceCtx;
import org.apache.commons.jexl3.JexlContext;

/**
 * 新闻Jexl参数设置器
 *
 * @author: guangxush
 * @create: 2020/09/27
 */
public class NewsJexlParamSetter implements JexlParamSetter{
    @Override
    public void setJexlContextParam(NewsBaseServiceCtx contextParam, JexlContext context) {
        context.set("topic", contextParam.getTopic());
    }
}

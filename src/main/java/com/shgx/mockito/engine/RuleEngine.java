package com.shgx.mockito.engine;

import com.shgx.mockito.model.BaseServiceCtx;
import com.shgx.mockito.model.BaseServiceResult;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 新闻判断引擎
 *
 * @author: guangxush
 * @create: 2020/09/27
 */
public interface RuleEngine<T extends BaseServiceCtx, R extends BaseServiceResult> {
    /**
     * 执行具体的新闻判断逻辑
     * @param context
     * @return
     */
    R execute(T context);

    /**
     * 检查上下文是否合法
     * @param context
     * @return
     */
    default boolean checkContext(T context){
        Assert.notNull(context);
        return StringUtils.isEmpty(context.getCode());
    }

}

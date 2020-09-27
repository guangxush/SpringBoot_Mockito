package com.shgx.mockito.action;

import com.shgx.mockito.model.ActionResult;
import com.shgx.mockito.model.BaseServiceCtx;

/**
 * @author: guangxush
 * @create: 2020/09/27
 */
public interface EngineAction<T extends BaseServiceCtx> {
    /**
     * 动作执行方法
     *
     * @param ctx
     * @return
     */
    ActionResult doAction(T ctx);

    /**
     * 获取actionCode
     *
     * @return
     */
    String actionCode();
}

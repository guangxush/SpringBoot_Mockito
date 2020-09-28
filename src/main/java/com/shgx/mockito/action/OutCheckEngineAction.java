package com.shgx.mockito.action;

import com.shgx.mockito.model.ActionResult;
import com.shgx.mockito.model.NewsBaseServiceCtx;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: guangxush
 * @create: 2020/09/28
 */
@Service
public class OutCheckEngineAction extends AbstractNewsCheckAction{

    @Override
    public ActionResult doAction(NewsBaseServiceCtx ctx) {
        //调用外部方法执行新闻校验
        return null;
    }

    @Override
    public String actionCode() {
        return "OutCheckEngineAction";
    }
}

package com.shgx.mockito.controller;

import com.shgx.mockito.action.NewsCheckAction;
import com.shgx.mockito.model.ActionResult;
import com.shgx.mockito.model.NewsBaseServiceCtx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guangxush
 * @create: 2020/09/28
 */
@RestController
public class NewsCheckController {

    @Autowired
    private NewsCheckAction newsCheckAction;

    @GetMapping("/check")
    public ActionResult checkNews(@RequestBody NewsBaseServiceCtx ctx){
        return newsCheckAction.doAction(ctx);
    }

    @GetMapping("/simple")
    public ActionResult simpleCheck(){
        NewsBaseServiceCtx ctx = new NewsBaseServiceCtx();
        ctx.setTopic("fun");
        ctx.setMessage("this is very fun!");
        return newsCheckAction.doAction(ctx);
    }
}

package com.shgx.mockito.rule;

import com.shgx.mockito.engine.RuleCheckAssembler;
import com.shgx.mockito.model.NewsBaseServiceCtx;
import com.shgx.mockito.model.Result;
import com.shgx.mockito.model.ResultCodeEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author: guangxush
 * @create: 2020/09/26
 */
public abstract class AbstractBaseRule implements BaseRule<NewsBaseServiceCtx> , InitializingBean, ApplicationContextAware {

    protected static Map<String, AbstractBaseRule> ruleFactory = Maps.newHashMap();

    private ApplicationContext applicationContext;

    @Override
    public Result analyze(NewsBaseServiceCtx context){
        if(context == null){
            String msg = "新闻上下文信息不能为空";
            return new Result(ResultCodeEnum.FAILURE, msg);
        }
        String errorMsg = check(context);
        if(!StringUtils.isEmpty(errorMsg)){
            return new Result(ResultCodeEnum.FAILURE, errorMsg);
        }
        return new Result(ResultCodeEnum.SUCCESS);
    }

    /**
     * 子类实现的新闻识别方法
     * @param context
     * @return
     */
    public abstract String check(NewsBaseServiceCtx context);

    /**
     * 子类返回condition条件，符合topic的新闻才会被执行
     * @return
     */
    public abstract String getCondition();

    /**
     * 将新闻规则注入到engine
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        RuleCheckAssembler checkAssembler = applicationContext.getBean("ruleCheckAssembler", RuleCheckAssembler.class);
        synchronized (checkAssembler.getRules()){
            checkAssembler.getRules().add(this);
            ruleFactory.put(this.getCondition(), this);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

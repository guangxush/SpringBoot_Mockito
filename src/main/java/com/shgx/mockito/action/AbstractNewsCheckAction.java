package com.shgx.mockito.action;

import com.shgx.mockito.engine.NewsCheckEngine;
import com.shgx.mockito.model.NewsBaseServiceCtx;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: guangxush
 * @create: 2020/09/27
 */
public abstract class AbstractNewsCheckAction implements EngineAction<NewsBaseServiceCtx>, InitializingBean, ApplicationContextAware {

    protected ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        NewsCheckEngine newsCheckEngine = applicationContext.getBean("newsCheckEngine", NewsCheckEngine.class);
        synchronized (newsCheckEngine.getNewsActionList()){
            // engine中添加此action方法
            newsCheckEngine.getNewsActionList().add(this);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

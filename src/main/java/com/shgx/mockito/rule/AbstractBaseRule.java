package com.shgx.mockito.rule;

import com.shgx.mockito.model.NewsBaseServiceCtx;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: guangxush
 * @create: 2020/09/26
 */
public abstract class AbstractBaseRule implements BaseRule<NewsBaseServiceCtx> , InitializingBean, ApplicationContextAware {

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}

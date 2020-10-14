package com.shgx.mockito.engine;

import com.shgx.mockito.model.NewsBaseServiceCtx;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsCheckEngineTest extends TestCase {

    @Autowired
    private NewsCheckEngine newsCheckEngine;

    @Test
    public void testExecute() {
        NewsBaseServiceCtx newsBaseServiceCtx = new NewsBaseServiceCtx();
        newsBaseServiceCtx.setMessage("hello");
        newsBaseServiceCtx.setTopic("world");
        newsBaseServiceCtx.setEngine("newsCheckEngine");
        newsCheckEngine.execute(newsBaseServiceCtx);
    }
}
package com.shgx.mockito.engine;

import com.google.common.collect.Maps;
import com.shgx.mockito.action.NewsCheckAction;
import com.shgx.mockito.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author: guangxush
 * @create: 2020/11/01
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoTest {

    /**
     * 被标记了@InjectMocks , 在myBefore方法中 执行 MockitoAnnotations.initMocks(this); 的时候，会将标记了 @Mock 或 @Spy 的属性注入到 service 中。
     */
    @InjectMocks
    private NewsCheckAction newsCheckAction;

    /**
     * @Mock, 那就是通常的方式，service里面的provider完全被Mock实例替换，所有的调用都是针对Mock生成类的。
     */
    @Mock
    private NewsCheckEngine newsCheckEngine;

    @Mock
    private RuleCheckAssembler ruleCheckAssembler;

    @Before
    public void myBefore() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 定义需要“假执行”的方法，并预先设定好该方法需要返回的值。当底层执行到该方法时，
     * 不会真正执行方法并返回自己预先设定好的值。
     * 注意点：实际调用方法传入的参数必须跟预先设定“假执行”的方法参数一致，否则不生效。
     * 如下：预先定义“假执行”newsCheckEngine.execute(serviceCtx)的方法参数是serviceCtx，
     * 那么newsCheckAction.doAction(serviceCtx)传入的但是也必须为serviceCtx
     */
    @Test
    public void testNewsCheckAction(){
        NewsBaseServiceCtx serviceCtx = new NewsBaseServiceCtx();
        BaseServiceResult checkResult = new BaseServiceResult(true, ResultCodeEnum.SUCCESS.getCode());
        Mockito.when(newsCheckEngine.execute(serviceCtx)).thenReturn(checkResult);
        System.out.println(newsCheckAction.doAction(serviceCtx));
    }

    /**
     *  使用when then Answer可以采用反射返回不同的值进行测试
     */
    @Test
    public void otherTest(){
        Mockito.when(newsCheckEngine.execute(Mockito.isA(NewsBaseServiceCtx.class))).thenAnswer(new Answer<BaseServiceResult>() {
            @Override
            public BaseServiceResult answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                // 获取参数
                NewsBaseServiceCtx serviceCtx = (NewsBaseServiceCtx) args[0];
                BaseServiceResult result = new BaseServiceResult(true);

                // 根据第1个参数，返回不同的值
                if (serviceCtx == null) {
                    throw new RuntimeException("异常");
                }else if (serviceCtx.getTopic()==null) {
                    result.setSuccess(false);
                    return result;
                }else if (serviceCtx.getTopic().equals("hello")) {
                    result.setSuccess(false);
                    result.setResultCode("world");
                    return result;
                }
                return result;
            }
        });
        NewsBaseServiceCtx serviceCtx = new NewsBaseServiceCtx();
        serviceCtx.setTopic("hello");
        Assert.assertEquals(newsCheckEngine.execute(serviceCtx).getResultCode(), "world");

        serviceCtx.setTopic(null);
        Assert.assertFalse(newsCheckEngine.execute(serviceCtx).isSuccess());

        try {
            newsCheckEngine.execute(null);
        } catch (RuntimeException ex) {
            Assert.assertEquals("异常", ex.getMessage());
        }
    }
}

package com.shgx.mockito.engine;

import com.shgx.mockito.dal.BayesAlgorithmDAL;
import com.shgx.mockito.model.AlgorithmDO;
import com.shgx.mockito.model.NewsBaseServiceCtx;
import com.shgx.mockito.rule.impl.NewsBayesCheckRule;
import com.shgx.mockito.service.impl.BayesAlgorithm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
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
public class MockitoBayesAlgorithmTest {
    @InjectMocks
    private NewsBayesCheckRule newsBayesCheckRule;

    @Mock
    private BayesAlgorithm bayesAlgorithm;

    @Mock
    private BayesAlgorithmDAL bayesAlgorithmDAL;

    @Before
    public void myBefore() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 定义需要“假执行”的方法，并预先设定好该方法需要返回的值。当底层执行到该方法时，
     * 不会真正执行方法并返回自己预先设定好的值。
     * 注意点：实际调用方法传入的参数必须跟预先设定“假执行”的方法参数一致，否则不生效。
     * 如下：预先定义“假执行”bayesAlgorithmDAL.findResultByKey(String id)的方法参数是"10001"，
     * 那么bayesAlgorithmDAL.findResultByKey("10001")传入与当前参数一致回返回true,否则返回false
     * bayesAlgorithmDAL.findResultByKey(Matchers.anyString())表示任意字符都返回true
     */
    @Test
    public void bayesCheckRuleTest(){
        Mockito.when(bayesAlgorithmDAL.findResultByKey("10001")).thenReturn(true);
        Assert.assertTrue(bayesAlgorithmDAL.findResultByKey("10001"));
        Assert.assertFalse(bayesAlgorithmDAL.findResultByKey("10002"));
        Mockito.when(bayesAlgorithmDAL.findResultByKey(Matchers.anyString())).thenReturn(true);
        Assert.assertTrue(bayesAlgorithmDAL.findResultByKey("****"));
    }

    /**
     *  如果rule层跟dal层方法参数实在做不到一致。
     *  如下：rule层newsBayesCheckRule.check(serviceCtx);
     *       dao层bayesAlgorithm.useModel(AlgorithmDO);
     *   这种情况我们使用Mockito.isA(AlgorithmDO.class); 定义只有方法参数是类对象AlgorithmDO就行
     */
    @Test
    public void bayesUserModelTest(){
        Mockito.when(bayesAlgorithm.useModel(Mockito.isA(AlgorithmDO.class))).thenReturn(false);
        NewsBaseServiceCtx serviceCtx = new NewsBaseServiceCtx();
        Assert.assertEquals("属于负面新闻", newsBayesCheckRule.check(serviceCtx));
        Mockito.when(bayesAlgorithm.useModel(Mockito.isA(AlgorithmDO.class))).thenReturn(true);
        Assert.assertNotEquals("属于负面新闻", newsBayesCheckRule.check(serviceCtx));
    }
}

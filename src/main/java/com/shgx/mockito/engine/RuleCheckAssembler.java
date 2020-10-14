package com.shgx.mockito.engine;

import com.google.common.collect.Lists;
import com.shgx.mockito.model.NewsBaseServiceCtx;
import com.shgx.mockito.rule.AbstractBaseRule;
import com.shgx.mockito.utils.JexlUtil;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 条件执行装配器
 *
 * @author: guangxush
 * @create: 2020/09/27
 */
public class RuleCheckAssembler {

    /**
     * 新闻信息检查器规则集合
     */
    private List<AbstractBaseRule> rules = Lists.newArrayList();

    /**
     * JexlContext参数设置集合
     */
    private List<JexlParamSetter> jexlParamSetters;

    public List<AbstractBaseRule> loadRules(NewsBaseServiceCtx ctx) {
        List<AbstractBaseRule> ruleList = new LinkedList<>();
        if (CollectionUtils.isEmpty(rules)) {
            return ruleList;
        }
        JexlContext context = toJexlContext(ctx);

        rules.forEach(r -> {
            if (parseValue(r.getCondition(), context)) {
                ruleList.add(r);
            }
        });
        return ruleList;
    }

    private boolean parseValue(String express, JexlContext context) {
        if (StringUtils.isEmpty(express)) {
            return false;
        }
        return JexlUtil.executeBoolean(express, context);
    }

    /**
     * 将新闻上下文信息加入jexl解析上下文
     *
     * @param ctx
     * @return
     */
    private JexlContext toJexlContext(NewsBaseServiceCtx ctx) {
        JexlContext context = new MapContext();
        for (JexlParamSetter jexlParamSetter : jexlParamSetters) {
            jexlParamSetter.setJexlContextParam(ctx, context);
        }
        return context;
    }

    public List<AbstractBaseRule> getRules() {
        return rules;
    }

    public void setRules(List<AbstractBaseRule> rules) {
        this.rules = rules;
    }

    public List<JexlParamSetter> getJexlParamSetters() {
        return jexlParamSetters;
    }

    public void setJexlParamSetters(List<JexlParamSetter> jexlParamSetters) {
        this.jexlParamSetters = jexlParamSetters;
    }
}

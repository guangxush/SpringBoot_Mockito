package com.shgx.mockito.utils;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;

/**
 * @author: guangxush
 * @create: 2020/09/27
 */
public class JexlUtil {
    private static final JexlEngine jexlEngine = new JexlBuilder().create();

    public static boolean executeBoolean(String script, JexlContext context){
        Boolean execute = (Boolean) execute(script, context);
        if(execute == null){
            return false;
        }
        return true;
    }

    public static Object execute(String express, JexlContext context){
        JexlExpression exp = jexlEngine.createExpression(express);
        return exp.evaluate(context);
    }
}

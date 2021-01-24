package com.jiangyu.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文环境角色
 * 作用：用来存储变量的值
 * @author JIAO
 *
 */
public class Context {
    private Map<VariablerExpression,Integer> map
            = new HashMap<VariablerExpression,Integer>();

    /**
     * 向环境对象内添加变量的值
     * @param v
     * @param value
     */
    public void add(VariablerExpression v,Integer value){
        map.put(v, value);
    }

    /**
     * 给定一个变量名   获取值的方法
     * @param v
     * @return
     */
    public Integer lookupValue(VariablerExpression v){
        return map.get(v);
    }
}


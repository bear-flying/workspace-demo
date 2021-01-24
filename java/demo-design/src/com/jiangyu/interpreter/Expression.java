package com.jiangyu.interpreter;

/**
 * 抽象表达式角色
 * @author JIAO
 *
 */
public abstract class Expression {
    public abstract int interpret(Context context);
}

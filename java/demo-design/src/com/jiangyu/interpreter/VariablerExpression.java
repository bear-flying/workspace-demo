package com.jiangyu.interpreter;

/*
 * 具体的表达式角色
 * 表示变量的表达式
 * 是一种终结符表达式
 */
public class VariablerExpression extends Expression {

    @Override
    public int interpret(Context context) {

        return context.lookupValue(this);
    }

}


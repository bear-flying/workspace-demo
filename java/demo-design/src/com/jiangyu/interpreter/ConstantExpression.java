package com.jiangyu.interpreter;

/**
 * 一种终结符表达式角色
 * 用来封装常量数字
 * @author JIAO
 *
 */
public class ConstantExpression extends Expression {
    private int i;
    public ConstantExpression(int i){
        this.i = i;
    }
    @Override
    public int interpret(Context context) {
        return i;
    }

}

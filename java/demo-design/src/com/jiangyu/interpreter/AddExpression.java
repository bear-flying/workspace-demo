package com.jiangyu.interpreter;

/**
 * 非终结符表达式
 * 用来解释+运算
 * @author JIAO
 *
 */
public class AddExpression extends Expression {
    private Expression left;
    private Expression right;
    public AddExpression(Expression left ,Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret(Context context) {
        return left.interpret(context)+right.interpret(context);
    }

}

package com.jiangyu.interpreter;

/**
 * 非终结符表达式
 * 用来解释 / 运算
 * @author JIAO
 *
 */
public class DivisionExpression extends Expression {
    private Expression left;
    private Expression right;
    public DivisionExpression(Expression left ,Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret(Context context) {
        try {
            return left.interpret(context)/right.interpret(context);
        } catch (Exception e) {
            System.out.println("除数为零了");
            return -1000000;
        }
    }

}
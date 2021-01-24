package com.jiangyu.interpreter;

/**
 * 解释器设计模式：
 *
 * 给定一个语言后，解释器模式可以定义出其问法的一种表示，并同时提供一个解释器。
 * 客户端可以使用这个解释器来解释这个语言中的句子。
 */
public class Client {

    public static void main(String[] args) {
        //1 将一个表达式 定义出         a*b/c+2       a=5  b=7  c=2
        VariablerExpression a = new VariablerExpression();
        VariablerExpression b = new VariablerExpression();
        VariablerExpression c = new VariablerExpression();
        ConstantExpression d = new ConstantExpression(2);

        //将变量放入环境内
        Context context = new Context();
        context.add(a, 5);
        context.add(b, 7);
        context.add(c, 2);

        //将 a*b/c+2  封装为一个表达式对象
        Expression ex =
                new DivisionExpression(
                        new MultiplyExpression(a, b),
                        new AddExpression(c, d));

        System.out.println("a=5,b=7,c=2  表达式a*b/c+2的结果是： "
                +ex.interpret(context));
    }

}
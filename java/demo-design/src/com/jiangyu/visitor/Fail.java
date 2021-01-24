package com.jiangyu.visitor;

/**
 * 具体的观察者角色
 * @author JIAO
 *
 */
public class Fail implements Visitor {

    @Override
    public void visit(Man man) {
        System.out.println("男人失败时，喝酒解闷");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("女人失败时，逛逛街，购购物");
    }

}

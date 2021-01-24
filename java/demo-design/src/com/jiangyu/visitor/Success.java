package com.jiangyu.visitor;

/**
 * 具体的观察者角色
 * @author JIAO
 *
 */
public class Success implements Visitor {

    @Override
    public void visit(Man man) {
        System.out.println("男人成功时，喝酒庆祝");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("女人成功时，逛逛街，购购物");
    }

}


package com.jiangyu.visitor;

public class Love implements Visitor {

    @Override
    public void visit(Man man) {
        System.out.println("男人谈恋爱时，总是表现的自己什么都懂");
    }

    @Override
    public void visit(Woman woman) {
        System.out.println("女人谈恋爱时，总是在男人面前表现的什么都不懂");
    }

}

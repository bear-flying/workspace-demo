package com.jiangyu.visitor;

public class Man implements Person {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}


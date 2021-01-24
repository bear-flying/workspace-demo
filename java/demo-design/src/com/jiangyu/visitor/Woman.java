package com.jiangyu.visitor;

public class Woman implements Person {

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}

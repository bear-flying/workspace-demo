package com.jiangyu.visitor;

/**
 * 抽象元素角色
 * @author JIAO
 *
 */
public interface Person {
    public void accept(Visitor v);
}
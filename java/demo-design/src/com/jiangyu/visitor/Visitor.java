package com.jiangyu.visitor;

/**
 * 抽象访问者角色
 * 为该对象结构中具体元素角色声明一个访问操作接口
 * @author JIAO
 *
 */
public interface Visitor {
    public void visit(Man man);
    public void visit(Woman woman);
}

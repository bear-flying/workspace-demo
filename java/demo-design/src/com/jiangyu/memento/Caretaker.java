package com.jiangyu.memento;

/**
 * 负责人角色
 * 负责外部存储备忘录角色对象
 * @author JIAO
 *
 */
public class Caretaker {
    private Memento m;
    //存储备忘录对象
    public void resotreMemento(Memento m){
        this.m = m;
    }

    //获取备忘录方法
    public Memento getMemento(){
        return m;
    }
}


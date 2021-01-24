package com.jiangyu.mediator;

/**
 * 抽象同事角色
 * @author JIAO
 *
 */
public abstract class Colleague {
    //持有一个调停者角色对象的引用
    protected Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public Colleague(Mediator mediator) {
        super();
        this.mediator = mediator;
    }

    public Colleague() {
        super();
        // TODO Auto-generated constructor stub
    }

}
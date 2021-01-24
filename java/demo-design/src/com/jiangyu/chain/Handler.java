package com.jiangyu.chain;

/**
 * 抽象处理器角色
 * @author JIAO
 *
 */
public abstract class Handler {
    //下一责任处理者
    protected Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }


    public abstract void handleRequest(String user,double fee);
}


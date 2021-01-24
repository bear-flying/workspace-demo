package com.jiangyu.observer2;

/**
 * 具体主题角色
 * @author JIAO
 *
 */
public class ConcreteTheme extends Theme {
    private String state;

    public ConcreteTheme(String state) {
        super();
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void change(String newState){
        this.state = newState;
        //通知所有注册在该主题的观察者进行更新状态
        this.notifyObservers(newState);
    }
}


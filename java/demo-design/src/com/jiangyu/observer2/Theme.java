package com.jiangyu.observer2;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题角色
 * @author JIAO
 *
 */
public abstract class Theme {
    private List<Observer> list = new ArrayList<Observer>();

    public void attach(Observer o){
        list.add(o);
    }

    public void detach(Observer o){
        list.remove(o);
    }

    public void notifyObservers(String state){
        for(Observer o:list){
            o.update(state);
        }
    }
}


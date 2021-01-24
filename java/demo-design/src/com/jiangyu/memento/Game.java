package com.jiangyu.memento;

/**
 * 发起人角色
 * 应该具有内部状态       游戏的进度
 * 应该能够将内部状态创建一个备忘录对象进行存储
 * @author JIAO
 *
 */
public class Game {
    //发起人的内部状态
    private String schedule;//游戏进度

    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    //创建快照/备忘录对象的方法
    public  Memento createMemento(){
        return new Memento(schedule);
    }
    /**
     * 恢复进度方法
     * @param m
     */
    public void returnSchedule(Memento m){
        this.schedule = m.getSchedule();
    }
}

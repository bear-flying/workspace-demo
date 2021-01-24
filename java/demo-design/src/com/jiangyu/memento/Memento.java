package com.jiangyu.memento;

/**
 * 备忘录角色
 * 负责存储发起人角色的内部状态
 * @author JIAO
 *
 */
public class Memento {
    private String schedule;//进度

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Memento(String schedule) {
        super();
        this.schedule = schedule;
    }

    public Memento() {
        super();
        // TODO Auto-generated constructor stub
    }

}

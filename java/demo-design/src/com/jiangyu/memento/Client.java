package com.jiangyu.memento;

/**
 * 备忘录\快照设计模式（memento）：
 *
 * 备忘录对象是一个用来存储另外一个对象内部状态的快照的对象。
 * 备忘录模式的用意是在不破坏封装的条件下，将一个对象的状态捉住，并外部化，存储起来，
 * 从而可以在将来合适的时候把这个对象还原到存储起来的状态。
 */
public class Client {

    public static void main(String[] args) {
        Game g = new Game();//发起者角色
        Caretaker c = new Caretaker();//负责人角色
        g.setSchedule("第三关");

        //创建游戏当前状态的备忘录对象   并存储在负责人角色内
        c.resotreMemento(g.createMemento());

        g.setSchedule("第5关");

        System.out.println(g.getSchedule());

        //恢复为上次备份存储的状态
        g.returnSchedule(c.getMemento());
        System.out.println(g.getSchedule());

    }

}

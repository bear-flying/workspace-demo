package com.jiangyu.decorator2;

/**
 * 传统方式
 * 实现警报门  就使用继承扩展的方式实现
 *
 * @author JIAO
 *
 */
public class AlarmDoor extends ConcreteDoor {
    public void alarm(){
        System.out.println("安装警报器");
    }
}

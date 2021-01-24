package com.jiangyu.decorator2;

/**
 * 具体构件角色
 * @author JIAO
 *
 */
public class ConcreteDoor implements Door {

    @Override
    public void open() {
        System.out.println("开门");
    }

    @Override
    public void close() {
        System.out.println("关门");
    }

    @Override
    public void lock() {
        System.out.println("锁门");
    }

}

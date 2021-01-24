package com.jiangyu.decorator2;

/**
 * 抽象装饰器角色
 * 扩展了抽象构件
 * @author JIAO
 *
 */
public abstract class DoorDecorator implements Door {
    protected Door door;
    @Override
    public void open() {
        door.open();
    }

    @Override
    public void close() {
        door.close();
    }

    @Override
    public void lock() {
        door.lock();
    }

}
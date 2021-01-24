package com.jiangyu.decorator2;

/**
 * 具体装饰器角色
 * 扩展了抽象装饰器
 * 可以给基本构件装饰附加警报功能
 * @author JIAO
 *
 */
public class AlarmDoorDecorator extends DoorDecorator {

    public AlarmDoorDecorator(Door door){
        this.door = door;
    }

    //装饰时扩展附件的功能
    public void alarm(){
        System.out.println("锁门时增加警报功能");
    }


    @Override
    public void lock() {
        alarm();
        this.door.lock();
    }
}

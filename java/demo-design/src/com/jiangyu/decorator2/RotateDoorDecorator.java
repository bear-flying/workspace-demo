package com.jiangyu.decorator2;

/**
 * 具体装饰器角色
 * 扩展了抽象装饰器
 * 可以给基本构件装饰附加旋转功能
 * @author JIAO
 *
 */
public class RotateDoorDecorator extends DoorDecorator {

    public RotateDoorDecorator(Door door){
        this.door = door;
    }

    //装饰时扩展附件的功能
    public void rotate(){
        System.out.print("开门时附加旋转功能-");
    }

    @Override
    public void open() {
        rotate();
        door.open();
    }

}

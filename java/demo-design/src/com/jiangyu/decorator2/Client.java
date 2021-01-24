package com.jiangyu.decorator2;

/*
 * 装饰者设计模式：
 *
 * 以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案，提供比继承更多的灵活性。
 * 动态给一个对象增加功能，这些功能可以再动态的撤消。
 * 增加由一些基本功能的排列组合而产生的非常大量的功能。
 *
 *
 *
 */
public class Client {

    public static void main(String[] args) {
        Door door = new ConcreteDoor();
        door.open();
        door.close();
        door.lock();

        System.out.println("--------下面为警报门功能--------");
        //将基本door组件  进行功能装饰     增加锁门时警报功能    产生一个警报门
        Door alarmDoor = new AlarmDoorDecorator(door);
        alarmDoor.open();
        alarmDoor.close();
        alarmDoor.lock();


        System.out.println("--------下面为旋转门功能--------");

        //将基本door组件  进行功能装饰     增加锁门时警报功能    产生一个警报门
        Door rotateDoor = new RotateDoorDecorator(door);
        rotateDoor.open();
        rotateDoor.close();
        rotateDoor.lock();

        System.out.println("--------下面为旋转警报门功能--------");
        Door alramDoor = new AlarmDoorDecorator(door);
        Door rotateAlarmDoor = new RotateDoorDecorator(alramDoor);
        rotateAlarmDoor.open();
        rotateAlarmDoor.close();
        rotateAlarmDoor.lock();

		/*AlarmDoor door2 = new AlarmDoor();
		door2.open();
		door2.close();
		door2.lock();
		door2.alarm();*/
    }

}


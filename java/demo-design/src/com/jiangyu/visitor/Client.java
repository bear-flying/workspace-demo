package com.jiangyu.visitor;

/**
 *
 * 访问者Visitor表示一个作用于某对象结构中各元素的操作。
 * 访问者模式可以使不修改各元素类的前提下定义作用于这些元素的新操作，也就是动态的增加新的状态操作方法。
 * Visitor模式是一种分离对象数据结构与行为的方法，通过这种分离，
 * 可以为一个已存在的类或类群增加新的操作而无需为它们作任何修改。
 *
 * 访问者模式的优点：
 * ●好的扩展性
 * 能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。
 * ●好的复用性
 * 可以通过访问者来定义整个对象结构通用的功能，从而提高复用程度。
 * ●分离无关行为
 * 可以通过访问者来分离无关的行为，把相关的行为封装在一起，构成一个访问者，这样每一个访问者的功能都比较单一。
 *
 * 访问者模式的缺点：
 * ●对象结构变化很困难
 * 不适用于对象结构中的类经常变化的情况，因为对象结构发生了改变，访问者的接口和访问者的实现都要发生相应的改变，代价太高。
 */
public class Client {

    public static void main(String[] args) {
        // 创建一个对象结构
        PersonStructure ps = new PersonStructure();

        //创建不同的的元素
        Man man = new Man();
        Woman woman = new Woman();


        ps.attach(man);
        ps.attach(woman);


        //访问者
        Visitor success  = new Success();
        ps.acceptVisitor(success);


        Visitor fail = new Fail();
        ps.acceptVisitor(fail);


        Visitor love = new Love();
        ps.acceptVisitor(love);



    }

}


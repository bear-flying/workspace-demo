package com.jiangyu.iterator;

/**
 * 迭代器设计模式：
 *
 * 可以顺序访问一个聚集中的元素而不必暴露聚集的内部表象。
 * 多个对象聚在一起形成的总体称之为聚集，聚集对象是能够包容一组对象的容器对象。
 * 迭代器模式将迭代逻辑封装到一个独立的子对象中，从而与聚集本身隔开。
 * 迭代模式简化了聚集的界面。每一个聚集对象都可以有一个或一个以上的迭代对象，每一个迭代的迭代状态可以是彼此独立的。
 * 迭代算法可以独立于聚集角色变化。
 *
 */
public class Client {

    public static void main(String[] args) {
        //ArrayList list = new ArrayList();
        //LinkedList list = new LinkedList();

        Collection list =new ArrayList(); //new LinkedList();

        for(int i=1;i<10;i++){
            list.add(i);
        }

        System.out.println(list.size());

        //ArrayList 迭代代码




        //LinkedList 迭代代码



        //想办法将不同算法的迭代    在客户端使用时统一为Iterator类型

        Iterator it =list.iterator();

        while(it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }


    }

}


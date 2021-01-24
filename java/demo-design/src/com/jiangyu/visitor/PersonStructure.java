package com.jiangyu.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构类
 * @author JIAO
 *
 */
public class PersonStructure {
    private List<Person> list = new ArrayList<Person>();

    public void attach(Person p){
        list.add(p);
    }
    public void detach(Person p){
        list.remove(p);
    }


    public void acceptVisitor(Visitor v){
        for(Person p:list){
            p.accept(v);
        }
    }

}

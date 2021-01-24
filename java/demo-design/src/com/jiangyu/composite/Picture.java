package com.jiangyu.composite;

import java.util.Vector;

/**
 * 复合/合成节点角色
 * 应该包含子节点
 * 应该具有操作子节点的方法
 * @author JIAO
 *
 */
public class Picture implements Graphic {
    //用来存放管理子节点
    private Vector<Graphic> list =
            new Vector<Graphic>();

    /**
     * 下面3个方法为管理子节点方法
     */
    public void add(Graphic g){
        list.add(g);
    }
    public void remove(Graphic g){
        list.remove(g);
    }
    public Graphic getChild(int index){
        return list.get(index);
    }


    @Override
    public void draw() {
        System.out.println("画一幅画:");
        for(Graphic g:list){
            g.draw();
        }
    }

}

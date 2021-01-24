package com.jiangyu.adapterdefault;

/**
 * 源角色
 * 需要被适配的角色
 * @author JIAO
 *
 */
public class ForeignPlayer {
    public void attack(){
        System.out.println("attack,attack,attack");
    }

    public void defend(){
        System.out.println("defend,defend,defend");
    }
}

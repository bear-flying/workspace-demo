package com.jiangyu.composite;

/**
 * 叶子节点角色
 *
 * @author JIAO
 *
 */
public class Rectangle implements Graphic {

    @Override
    public void draw() {
        System.out.println("一个长方形");
    }

}

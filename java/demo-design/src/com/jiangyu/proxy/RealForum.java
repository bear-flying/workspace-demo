package com.jiangyu.proxy;

/**
 * 真实主题角色
 * @author JIAO
 *
 */
public class RealForum implements Forum {

    @Override
    public void addPost() {
        System.out.println("发布一个贴子");
    }

}

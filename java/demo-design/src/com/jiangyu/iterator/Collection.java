package com.jiangyu.iterator;

/**
 * 抽象容器接口  角色
 * @author JIAO
 *
 */
public interface Collection {
    public void add(Object o);
    public int size();
    public Iterator iterator();
}

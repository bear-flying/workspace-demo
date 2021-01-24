package com.jiangyu.iterator;

/**
 * 模拟数组集合
 * 使用数组来模拟集合的概念
 * @author JIAO
 *
 */
public class ArrayList implements Collection{
    //存放元素的数组   来模拟集合
    private Object[] objs = new Object[10];
    //标示集合中元素存放的位置及个数
    int index = 0;

    /**
     * 集合添加元素功能
     * @param obj
     */
    public void add(Object obj){
        //数组已经满了     应该扩展数组来模拟集合
        if(index==objs.length){
            Object[] newObjs = new Object[objs.length+10];
            //将旧数组中元素拷贝到新数组的过程
            System.arraycopy(objs, 0, newObjs, 0, objs.length);
            //将旧数组对象的引用指向扩展的新数组
            objs = newObjs;
        }
        objs[index]=obj;
        index++;
    }

    //获取集合元素的个数
    public int size(){
        return index;
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            int currentIndex=0;
            @Override
            public boolean hasNext() {
                if(currentIndex>=index)
                    return false;
                else
                    return true;
            }

            @Override
            public Object next() {
                return objs[currentIndex++];
            }

        };
    }
}


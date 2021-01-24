package com.jiangyu.composite;

/**
 * 合成设计模式：
 *
 * 将对象组织到树结构中，可以用来描述整体与部分的关系。合成模式就是一个处理对象的树结构的模式。
 * 合成模式把部分与整体的关系用树结构表示出来。
 * 合成模式使得客户端把一个个单独的成分对象和由他们复合而成的合成对象同等看待。
 * 一个文件系统就是一个典型的合成模式系统。树上长有节点。节点分为树枝和树叶两种。
 * 树枝：即目录，有内部树结构，图中带阴影的部分。
 * 树叶：即文件，没有内部结构，图中不带阴影的部分。
 * 显然，可以把目录和文件当做同一种对象看待和处理，就是合成模式。
 *
 *
 */
public class Client {

    public static void main(String[] args) {
        // 根     应该是一个合成节点
        Picture root = new Picture();

        //叶子
        Graphic line = new Line();
        Graphic circle = new Circle();
        Graphic rectangle = new Rectangle();

        //添加三个叶子节点
        root.add(line);
        root.add(circle);
        root.add(rectangle);


        //创建一个合成节点picture
        Picture picture = new Picture();
        picture.add(new Line());
        picture.add(new Line());
        picture.add(new Circle());


        //将一个合成节点picture加入到根节点
        root.add(picture);

        //画这个树
        root.draw();
    }

}


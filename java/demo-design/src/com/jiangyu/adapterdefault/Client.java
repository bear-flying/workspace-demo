package com.jiangyu.adapterdefault;

/**
 * 缺省适配器模式：
 * 为一个接口提供缺省实现，这样子类型可以从这个缺省实现
 * 类进行扩展，而不必从原有的接口进行扩展。通常这个缺省
 * 实现类可以是一个抽象类。
 *
 *
 * 很多时候一个接口的扩展类不需要实现所有的方法，而是需
 * 要某一两个方法即可，从原接口扩展必须实现所有方法，而
 * 从该缺省实现类扩展只需要重写需要的方法即可。
 *
 * 案例：AWT事件处理
 */
public class Client {

    public static void main(String[] args) {
        NBAPlayer player1 = new USPlayer();
        player1.go();
        player1.back();


        ForeignPlayer foreignPlayer = new ForeignPlayer();
        NBAPlayer player2 = new PlayerAdapter(foreignPlayer);
        player2.go();
        player2.back();
    }

}

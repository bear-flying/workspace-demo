package com.jiangyu.adapterdefault;

public class USPlayer implements NBAPlayer {

    @Override
    public void go() {
        System.out.println("go,go,go");
    }

    @Override
    public void back() {
        System.out.println("back,back,back");
    }

}


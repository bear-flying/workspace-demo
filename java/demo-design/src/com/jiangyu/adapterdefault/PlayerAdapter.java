package com.jiangyu.adapterdefault;

/**
 * 适配器角色
 * 需要将源角色ForeignPlayer适配为目标角色NBAPlayer
 * 以及ForeignPlayer的子类也需要适配
 * 所以选择对象类型适配器模式
 * @author JIAO
 *
 */
public class PlayerAdapter implements NBAPlayer {
    //需要适配的对象的引用
    private ForeignPlayer player;
    public PlayerAdapter(ForeignPlayer player){
        this.player = player;
    }
    @Override
    public void go() {
        player.attack();

    }

    @Override
    public void back() {
        player.defend();
    }

}

package com.jiangyu.mediator;

/**
 * 具体同事角色
 * 声卡
 * @author JIAO
 *
 */
public class SoundCard extends Colleague {
    public SoundCard(Mediator mediator){
        this.mediator = mediator;
    }

    public void soundData(String data){
        System.out.println("声音:"+data);
    }
}

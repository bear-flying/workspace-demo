package com.jiangyu.mediator;

/**
 * 具体同事角色
 * 显卡
 * @author JIAO
 *
 */
public class VideoCard extends Colleague {
    public VideoCard(Mediator mediator){
        this.mediator = mediator;
    }

    public void videoData(String data){
        System.out.println("画面显示:"+data);
    }
}


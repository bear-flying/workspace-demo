package com.jiangyu.mediator;

public class CPU extends Colleague {
    //存放视频数据
    private String videoData;
    //存放音频数据
    private String soundData;
    public String getVideoData() {
        return videoData;
    }
    public void setVideoData(String videoData) {
        this.videoData = videoData;
    }
    public String getSoundData() {
        return soundData;
    }
    public void setSoundData(String soundData) {
        this.soundData = soundData;
    }

    /**
     * 处理光驱读到的数据data    分解为音频和视频数据
     * 并通知调停者主板，可以让声卡同事和显卡同事工作了
     * @param data  data应该包含音频和视频两部分数据
     * 目前演示是使用    xxx,xxxxx  结构的字符串来模拟
     */
    public void executeData(String data){
        String [] datas = data.split(",");
        this.videoData = datas[0];
        this.soundData = datas[1];

        //通知调停者
        this.getMediator().changed(this);
    }
}

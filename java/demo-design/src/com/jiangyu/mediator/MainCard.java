package com.jiangyu.mediator;

/**
 * 具体调停者角色
 * 主板
 * 负责维持    光驱、CPU、声卡、显卡的关系
 * @author JIAO
 *
 */
public class MainCard implements Mediator {
    private CDDriver cd;
    private CPU cpu;
    private VideoCard video;
    private SoundCard sound;


    public CDDriver getCd() {
        return cd;
    }


    public void setCd(CDDriver cd) {
        this.cd = cd;
    }


    public CPU getCpu() {
        return cpu;
    }


    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }


    public VideoCard getVideo() {
        return video;
    }


    public void setVideo(VideoCard video) {
        this.video = video;
    }


    public SoundCard getSound() {
        return sound;
    }


    public void setSound(SoundCard sound) {
        this.sound = sound;
    }


    @Override
    public void changed(Colleague c) {
        if(c instanceof CDDriver){//光驱
            //可以让主板这个调停者通知CPU工作了
            String data  = ((CDDriver)c).getData();
            cpu.executeData(data);
        }else if(c instanceof CPU){//CPU
            //CPU处理完数据    通知主板    可以将数据使用   声卡和显卡显示了
            String videoData = ((CPU)c).getVideoData();
            String soundData =  ((CPU)c).getSoundData();
            video.videoData(videoData);//显卡作用
            sound.soundData(soundData);//声卡作用
        }

    }

}


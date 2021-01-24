package com.jiangyu.command;

/**
 * 具体命令角色
 * 包含一个接收者角色对象的引用
 * @author JIAO
 *
 */
public class ChangeChannelCommand implements Command {
    private TV tv;
    private int channel;
    public ChangeChannelCommand(TV tv,int channel){
        this.tv = tv;
        this.channel = channel;
    }
    @Override
    public void execute() {
        tv.changeChannel(channel);
    }

}

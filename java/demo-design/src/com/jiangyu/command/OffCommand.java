package com.jiangyu.command;

/**
 * 具体命令角色
 * 包含一个接收者角色对象的引用
 * @author JIAO
 *
 */
public class OffCommand implements Command {
    private TV tv;
    public OffCommand(TV tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        tv.turnOff();
    }

}
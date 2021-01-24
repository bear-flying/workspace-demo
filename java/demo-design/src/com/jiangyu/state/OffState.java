package com.jiangyu.state;

/**
 * 具体状态角色
 * @author JIAO
 *
 */
public class OffState implements LightState {

    @Override
    public void press() {
        System.out.println("关闭灯");
    }

}

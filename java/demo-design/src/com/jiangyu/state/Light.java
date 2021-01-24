package com.jiangyu.state;

/**
 * 环境角色Context
 * @author JIAO
 *
 */
public class Light {
    private LightState state;

    public LightState getState() {
        return state;
    }

    public void setState(LightState state) {
        this.state = state;
    }
    public void pressButton(){
        state.press();
    }
}

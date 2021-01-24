package com.jiangyu.mediator;

/*
 * 具体同事角色
 * 表示光驱
 */
public class CDDriver extends Colleague {
    //存储光驱读到的数据
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * 读光盘数据
     * @param data 光盘内的数据
     */
    public void readCD(String data){
        this.data = data;
        this.getMediator().changed(this);
    }
}


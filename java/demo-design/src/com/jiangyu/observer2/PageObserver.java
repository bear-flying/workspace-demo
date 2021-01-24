package com.jiangyu.observer2;

public class PageObserver implements Observer {

    private String pageState;
    private String pageLevel;


    public PageObserver(String pageLevel) {
        super();
        this.pageLevel = pageLevel;
    }


    public String getPageState() {
        return pageState;
    }


    public void setPageState(String pageState) {
        this.pageState = pageState;
    }


    public String getPageLevel() {
        return pageLevel;
    }


    public void setPageLevel(String pageLevel) {
        this.pageLevel = pageLevel;
    }


    @Override
    public void update(String state) {
        pageState = state;
        //System.out.println("");
    }

}


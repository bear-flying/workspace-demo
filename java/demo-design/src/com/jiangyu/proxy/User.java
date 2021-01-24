package com.jiangyu.proxy;

public class User {
    private String name;
    private int auth;//人员的权限     0表示游客      1系统用户

    public User(){ }

    public User(String name, int auth) {
        super();
        this.name = name;
        this.auth = auth;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAuth() {
        return auth;
    }
    public void setAuth(int auth) {
        this.auth = auth;
    }

}

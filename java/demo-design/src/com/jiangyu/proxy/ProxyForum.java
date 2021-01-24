package com.jiangyu.proxy;

/**
 * 代理主题角色
 * @author JIAO
 *
 */
public class ProxyForum implements Forum {
    private Forum realForum;
    private User user;
    public ProxyForum(Forum realForum,User user){
        this.realForum = realForum;
        this.user = user;
    }
    @Override
    public void addPost() {
        if(user.getAuth()==0){//游客
            System.out.println("您是一个游客，没有发帖权限");
        }else if(user.getAuth()==1){
            realForum.addPost();
        }
    }

}


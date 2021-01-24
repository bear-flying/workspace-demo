package com.jiangyu.chain;

/**
 * 具体处理者角色
 * 总经理
 * 		能够处理5000内的申请
 * @author JIAO
 *
 */
public class GeneralManager extends Handler {

    @Override
    public void handleRequest(String user, double fee) {
        if(fee<=5000){//总经理可以批准5000内的请求
            if("张三".equals(user)){
                System.out.println(user+"发起申请经费"+fee+"获得批准");
            }else{
                System.out.println(user+"发起申请经费"+fee+"没有批准");
            }
        }else{//总经理不能处理5000以上的请求，应该交个下个环节处理
            if(this.getNextHandler()!=null){
                this.getNextHandler().handleRequest(user, fee);
            }else{
                System.out.println(user+"发起申请经费"+fee+"没有批准");
            }
        }
    }

}


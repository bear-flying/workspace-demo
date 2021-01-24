package com.jiangyu.chain;

/**
 * 具体处理者角色
 * 部门经理
 * 		能够处理1000内的申请
 * @author JIAO
 *
 */
public class DeptManager extends Handler {

    @Override
    public void handleRequest(String user, double fee) {
        if(fee<=1000){//部门经理可以批准1000内的请求
            if("张三".equals(user)){
                System.out.println(user+"发起申请经费"+fee+"获得批准");
            }else{
                System.out.println(user+"发起申请经费"+fee+"没有批准");
            }
        }else{//部门经理不能处理1000以上的请求，应该交个下个环节处理
            if(this.getNextHandler()!=null){
                this.getNextHandler().handleRequest(user, fee);
            }else{
                System.out.println(user+"发起申请经费"+fee+"没有批准");
            }
        }
    }

}


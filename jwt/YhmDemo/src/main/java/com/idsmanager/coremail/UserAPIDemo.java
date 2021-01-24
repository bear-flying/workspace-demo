/*
 * Copyright (c) 2016 Mailtech.cn, Ltd. All Rights Reserved.
 */

package com.idsmanager.coremail;

import tebie.applib.api.APIContext;
import tebie.applib.api.IClient;
import java.net.*;

/**
 * Created by coremail on 2016/11/17.
 */
public class UserAPIDemo {
    String cmHost;
    final int apiPort = 6195;

    public UserAPIDemo(String cmHost) {
        this.cmHost = cmHost;
    }

    /**
     * 获取邮箱用户单点登录链接
     * @param userEmail 用户邮箱地址
     * @param loginAttrs 登录参数，参数说明见docs文档
     * @return 单点登录链接，跳转到该链接即可进入邮箱
     * @throws Exception
     */
    public String userLogin(String userEmail, String loginAttrs) throws Exception {
        Socket socket = new Socket(cmHost, apiPort);
        IClient client = APIContext.getClient(socket);
        try {
            APIContext result = client.userLoginEx(userEmail, loginAttrs);
            if (result.getRetCode() == APIContext.RC_NORMAL) {
                // 登录成功，从结果中提取 sid 并进入邮箱页面
                String encodedResult = result.getResult();
                String sid = getParameter(encodedResult, "sid");
                String webname = getParameter(encodedResult, "webname");
                // Coremail 的 Webmail 主页
                String mainURL = webname + "/coremail/main.jsp?sid=" + sid;
                // 返回单点登录链接
                return mainURL;
            } else {
                // 登录失败，记录相关失败信息
                System.out.println("User login failed, code=" + result.getRetCode()
                        + ", msg=" + result.getErrorInfo());
            }
        } finally {
            client.close();
        }
        return null;
    }

    /**
     * 创建用户
     * @param providerId 固定为"1"
     * @param orgId      组织标识
     * @param userId     用户名
     * @param domainName 域名
     * @param cosId      服务等级标识，缺省服务为"1"
     * @param userStatus 用户状态，正常为"0"，停用为"1"，锁定为"4"
     * @param attrs      用户属性，英文逗号分隔，例如："true_name=xxx&password=xxx&mobile_number=xxx"，更多属性及说明详见文档
     * @throws Exception
     */
    public void createUser(String providerId, String orgId, String userId, String domainName, String cosId, String userStatus, String attrs) throws Exception {
        Socket socket = new Socket(cmHost, apiPort);
        IClient client = APIContext.getClient(socket);
        try {
            APIContext result = client.createUser(providerId, orgId, userId, "domain_name=" + domainName + "&cos_id=" + cosId + "&user_status=" + userStatus + "&" + attrs);
            if (result.getRetCode() == 0) {
                String userEmail = userId + "@" + domainName;
                System.out.println("User created: " + userEmail);
            } else {
                System.out.println("User create failed, code=" + result.getRetCode()
                        + ", msg=" + result.getErrorInfo());
            }
        } finally {
            client.close();
        }
    }

    /**
     * 删除用户
     * @param userEmail 用户邮件地址
     * @throws Exception
     */
    public void deleteUser(String userEmail) throws Exception {
        Socket socket = new Socket(cmHost, apiPort);
        IClient client = APIContext.getClient(socket);
        try {
            APIContext result = client.deleteUser(userEmail);
            if (result.getRetCode() == 0) {
                System.out.println("User deleted: " + userEmail);
            } else {
                System.out.println("User delete failed, code=" + result.getRetCode()
                        + ", msg=" + result.getErrorInfo());
            }
        } finally {
            client.close();
        }
    }

    /**
     * 修改用户属性
     * @param userEmail 用户邮件地址
     * @param attrs     变更的属性值，key1=value1&key2=value2&key3=value3，用户属性列表详见文档
     * @throws Exception
     */
    public void updateUser(String userEmail, String attrs) throws Exception {
        Socket socket = new Socket(cmHost, apiPort);
        IClient client = APIContext.getClient(socket);
        try {
            APIContext result = client.changeAttrs(userEmail, attrs);
            if (result.getRetCode() == 0) {
                System.out.println("User updated: " + userEmail);
            } else {
                System.out.println("User update failed, code=" + result.getRetCode()
                        + ", msg=" + result.getErrorInfo());
            }
        } finally {
            client.close();
        }
    }

    /**
     * 禁用用户(将用户属性user_status置为4即可)
     * @param userEmail 用户邮件地址
     */
    public void disableUser(String userEmail) throws Exception {
        updateUser(userEmail, "user_status=4");
    }

    /**
     * 从接口返回结果中获取指定部分的值
     * @param encodedResult 接口返回结果
     * @param key 要获取值的key
     * @return 值
     * @throws Exception
     */
    private String getParameter(String encodedResult, String key) throws Exception {
        int start;
        if (encodedResult.startsWith(key + '=')) {
            start = key.length() + 1;
        } else {
            int i = encodedResult.indexOf('&' + key + '=');
            if (i == -1) {
                return null;
            }
            start = i + key.length() + 2;
        }

        int end = encodedResult.indexOf('&', start);
        String value = (end == -1)
                ? encodedResult.substring(start)
                : encodedResult.substring(start, end);

        return URLDecoder.decode(value, "GBK");
    }
}

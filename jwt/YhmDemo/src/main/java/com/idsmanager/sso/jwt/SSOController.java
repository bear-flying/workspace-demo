package com.idsmanager.sso.jwt;

import com.idsmanager.dingdang.jwt.DingdangUserRetriever;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/jwt/sso/")
public class SSOController {
    private static final Logger LOG = LoggerFactory.getLogger(SSOController.class);

    @RequestMapping("login")
    public String ssoUrl(@RequestParam String id_token, String redirect_url, Model model, HttpServletRequest request){
        String publicKey = PublicKey.publickey;
        //1.使用公钥，解析id_token
        // 使用publicKey解密上一步获取的id_token令牌
        DingdangUserRetriever retriever = new DingdangUserRetriever(id_token, publicKey);
        DingdangUserRetriever.User user = null;
        try {
            //2.获取用户信息
            user = retriever.retrieve();
        } catch (Exception e) {
            model.addAttribute("error", "Retrieve SSO user failed");
            return "error";
        }
        //3.判断用户名是否在自己系统存在isExistedUsername()方法为业务系统自行判断数据库中是否存在
        if (isExistedUsername(user.getUsername())) {
            //4.如果存在,登录成功，返回登录成功后的页面
            /*User spUser = userService.updateLoginTimes(user.getUsername());
            request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, saveSecurity(spUser));*/
            //5.如果注册时添加redirect_url，那么返回此自定义url页面
            if (StringUtils.isNotEmpty(redirect_url)) {
                return "redirect:" + redirect_url;
            }
            //6.否则返回系统默认操作页面
            return "redirect:../../index";
        } else {
            //7.如果不存在,返回登录失败页面,提示用户不存在
            model.addAttribute("error", "username { " + user.getUsername() + " } not exist");
            return "error";
        }
    }

    public boolean isExistedUsername(String username){
        if(username.isEmpty() || username.length() == 0 || username == null){
            return false;
        }else {
            return true;
        }
    }
}

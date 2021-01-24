package com.baidu.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.user.pojo.User;
import com.baidu.user.service.ActiveMqSender;
import com.baidu.user.service.IUserService;
import com.baidu.utils.ChangeWord;
import com.baidu.utils.HttpClientUtil;
import com.baidu.utils.Md5Util;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ActiveMqSender activeMqSender;
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：MQ发送消息
	 * 时间：2016年1月25日
	 * 作者：1405javab 姜宇
	 */
	@RequestMapping("mqsend")
	public void mqsend(){
		System.out.println("111");
		activeMqSender.send("111", "bbb");
	}
	
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：转到注册页面
	 * 时间：2016年1月4日
	 * 作者：1405javab 姜宇
	 */
	@RequestMapping("toRegister")
	public String toRegister(){
		return "user/register";
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：转到登陆页面
	 * 时间：2016年1月4日
	 * 作者：1405javab 姜宇
	 */
	@RequestMapping("toLogin")
	public String toLogin(){
		return "user/login";
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：用户注册
	 * 时间：2016年1月4日
	 * 作者：1405javab 姜宇
	 */
	@RequestMapping("register")
	public void register(User user) {
		
		userService.register(user);
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：用户登陆
	 * 时间：2016年1月4日
	 * 作者：1405javab 姜宇
	 */
	@RequestMapping("login")
	public void login(User user,HttpServletResponse response) {
		
		try {
			userService.login(user);
			response.getWriter().print("ok");
		} catch (Exception e) {
			String message = e.getMessage();
			try {
				response.getWriter().print(message);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public String getToken(String url){
		return null;
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：第三方登陆
	 * 时间：2016年1月7日
	 * 作者：1405javab 姜宇
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping("otherLogin")
	public String otherLogin(String code,Model model) {//获取百度社会化服务传递的code
		
		String url="https://openapi.baidu.com/social/oauth/2.0/token";
        //social redirect_uri registered in developer.baidu.com
		String redirect_uri = 
              "http://127.0.0.1:8080/onlyone/user/otherLogin.do";
		Map paramsMap = null;
		String client_id = "iZ2OrS1XxmK0udqo4Mwcbiuz";
		String client_secret = "pErxPcTIkl2UvL1XurwinOkS5zNrQRuA";
		paramsMap =new HashMap<String, String>();
		paramsMap.put("grant_type", "authorization_code");
		paramsMap.put("client_id", client_id);//[在“基本信息”中的API Key的值];
		paramsMap.put("client_secret", client_secret);//[在“基本信息”中的Secret Key 的值]
		paramsMap.put("redirect_uri", redirect_uri);
		paramsMap.put("code", code);
		//获取（令牌token等）相关信息: "expires_in":7776000,"access_token":"51.902629ff03554983f841f27798f621d6.7776000.1459904659.3674570194-7606124","session_secret":"495b196ac81dfe01e4a9eb8062358051","session_key":"8aKDBFBCXPSSQaItNTOionA3GGAAJS6kXGatsgIfKrWT9CREbjP\/sXTLlhK9tIBIygCCmxW+fVjj7NFZ7HMwC8\/mkIae2EZZlg==","name":"\u5929\u84dd\u84dd\u7237\u7237","media_uid":"16AE426C7300F185C7D88FBFC0F34C20","social_uid":3674570194,"media_type":"qqdenglu"
		String returnJson =HttpClientUtil.post(url, paramsMap);
		System.out.println(returnJson);
		//从相关信息中 获取令牌
		String access_token  =
				JSONObject.fromObject(returnJson).get("access_token").toString();
		
		
		//根据令牌获取合作网站的账号信息
		url="https://openapi.baidu.com/social/api/2.0/user/info";
		paramsMap.clear();
		paramsMap.put("access_token", access_token);
		//获取用户信息---- 图片 昵称等  //获取第三方网站用户名
		returnJson = HttpClientUtil.post(url, paramsMap);
		System.out.println(returnJson);
		JSONObject json = JSONObject.fromObject(returnJson);
		String username = json.get("username").toString();
		String social_uid = json.get("social_uid").toString();//获取社会化平台的统一uid
		
		//判断用户是否登陆过
		Boolean flag = userService.checkIsfirst(social_uid);
		//如果登陆过  就跳转首页
		//没有登陆过  就跳转到完善用户信息页面
		if(!flag){
			return "index";
		}else{
			//放进作用域里面
			model.addAttribute("nickName", ChangeWord.unicodeToChinese(username));
			model.addAttribute("social_uid", social_uid);
			model.addAttribute("access_token", access_token);
			return "user/otherMsg";
		}
		
	}
	
	/**
	 * 
	 * @author 飞天猫熊
	 * 功能：第三方用户完善信息 和 绑定
	 * 时间：2016年1月7日
	 * 作者：1405javab 姜宇
	 * @param user
	 */
	@RequestMapping("finishOtherMsg")
	public void finishOtherMsg(User user,String access_token) {
		userService.finishOtherMsg(user);
		
		//查看绑定状态
		String url="https://openapi.baidu.com/social/api/2.0/user/bind_status";
		Map paramsMap =new HashMap<String, String>();
		paramsMap.put("access_token", access_token);
		String returnJson =HttpClientUtil.post(url, paramsMap);
		JSONObject json = JSONObject.fromObject(returnJson);
		Object obj = json.get("media_type");
		if(obj==null){
			//与第三方绑定
			url = "https://openapi.baidu.com/social/api/2.0/user/bind";
			paramsMap.put("uid", user.getId());
			paramsMap.put("uid_sign",Md5Util.getMD5(user.getId()+"pErxPcTIkl2UvL1XurwinOkS5zNrQRuA"));
			returnJson =HttpClientUtil.post(url, paramsMap);
			json = JSONObject.fromObject(returnJson);
			String result = json.get("result").toString();
			System.out.println(result);
			
		}
		
	}
	
	
	
}

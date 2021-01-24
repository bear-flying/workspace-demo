package com.hthl.jwt.web.controller;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.idsmanager.dingdang.jwt.DingdangUserRetriever;
import com.idsmanager.dingdang.jwt.DingdangUserRetriever.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * 
 * @author JiangYu
 * JWT单点登录
 *
 */
@Controller
@RequestMapping("/api/jwt")
public class JwtApiController {

	//id_token 是IPG请求时带来的，在body里获取，publicKey是在IPG里注册应用时生成的，注册完可见，此示例代码是获取用户信息。
	//JWT SSO
	@RequestMapping(value = "/login.do")
	public String ssoUrl(@RequestParam String id_token, String redirect_url, 
			Model model, HttpServletRequest request) {
		
	    //1.接收方法为GET方式,参数名为id_token
	    //2.<解析令牌>为解析id_token并验证代码
		
		//1.使用公钥，解析id_token
		// 使用publicKey解密上一步获取的id_token令牌
		
		String publicKey = "feimao";
		
		try {
			Claims parseJWT = parseJWT(id_token, publicKey);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		DingdangUserRetriever retriever = new DingdangUserRetriever(id_token, publicKey);
		DingdangUserRetriever.User user = null;
		try {
		    //2.获取用户信息
		    user = retriever.retrieve();
		} catch (Exception e) {
		    //LOG.warn("Retrieve SSO user failed" , e);
		    return "error";
		}
		//3.判断用户名是否在自己系统存在isExistedUsername()方法为业务系统自行判断数据库中是否存在
		if (true) {//isExistedUsername(user.getUsername())
		    //4.如果存在,登录成功，返回登录成功后的页面
		    //User spUser = userService.updateLoginTimes(user.getUsername());
		    //request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, saveSecurity(spUser));
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
	
	  public Claims parseJWT(String jwt, String publicKey) throws Exception{
	        Claims claims = Jwts.parser()  //得到DefaultJwtParser
	           .setSigningKey(publicKey)         //设置签名的秘钥
	           .parseClaimsJws(jwt).getBody();//设置需要解析的jwt
	        return claims;
	    }
	  
	  /**
	     * 由字符串生成加密key
	     * @return
	     */
	    public SecretKey generalKey(){
	        String publicKey = "aiqinhai";
	        byte[] encodedKey = Base64.decodeBase64(publicKey);//本地的密码解码[B@152f6e2
	        // 根据给定的字节数组使用AES加密算法构造一个密钥
	        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
	        return key;
	    }
	
	  
	  
}

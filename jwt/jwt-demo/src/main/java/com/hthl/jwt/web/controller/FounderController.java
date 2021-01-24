package com.hthl.jwt.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hthl.jwt.sdk.utils.HttpClientPostFs;
import com.idsmanager.dingdang.jwt.DingdangUserRetriever;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Controller
@RequestMapping("/founder")
public class FounderController {

	@RequestMapping(value = "/login")
	public void login(@RequestParam String id_token, String redirect_url, Model model, 
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		String publicKey = "";
		
		if (id_token == null || id_token.equals("")) {
    		//CommonToolUtil.outputJson(request,response, "token错误！");
			System.out.println("token错误！");
		}
    	//使用公钥publicKey解析id_token令牌
    	DingdangUserRetriever retriever = new DingdangUserRetriever(id_token, publicKey);
        DingdangUserRetriever.User user = null;
        String userName = null;
        try {
            //获取用户信息
            user = retriever.retrieve();
            userName = user.getUsername();
            if(userName.isEmpty() || userName == null){
            	//CommonToolUtil.outputJson(request, response, "拒绝授权！");
            	System.out.println("拒绝授权！");
            }
            String passWord = "1234";//String passWord = appService.getPasskey(userName);
            if(passWord.isEmpty() || passWord == null){
            	//CommonToolUtil.outputJson(request, response, "拒绝授权！");
            	System.out.println("拒绝授权！");
            }
            if (StringUtils.isNotEmpty(redirect_url)) {
            	response.sendRedirect(response.encodeRedirectURL(redirect_url));  
            }
            //跳转登陆页
            String loginUrl = "http://47.97.75.226:8080//xy/auth.do";
            HttpClientPostFs http = new HttpClientPostFs(response);
			http.setParameter("UserCode",userName);
			http.setParameter("UserPassword",passWord);
			http.sendByPost(loginUrl, "http://47.97.75.226:8080//xy/Entry.do?s=1");
        } catch (ExpiredJwtException e) {
        	//CommonToolUtil.outputJson(request,response, "登录过期！");
        	System.out.println("登录过期！");
		} catch (SignatureException e) {
			//CommonToolUtil.outputJson(request,response, "拒绝授权！");
			System.out.println("拒绝授权！");
		} catch (Exception e) {
			//CommonToolUtil.outputJson(request,response, "请稍后再试！");
			System.out.println("请稍后再试！");
		}
		
		/**
		 * 
 		// 验证JWT的签名，返回CheckResult对象
    	CheckResult checkResult = TokenMgr.validateJWT(id_token, configure.getJwtPublicKey());
        
    	if (checkResult.isSuccess()) {
    		Claims claims = checkResult.getClaims();
    		System.out.println("token校检通过checkResult：" + checkResult.toString());
    		SubjectModel user = new ObjectMapper().readValue(claims.getSubject(), SubjectModel.class);
    		System.out.println("token校检通过user：" + user.toString());
    		
    		String loginUrl = configure.getWebsiteUrl() + "/xy/Entry.do?s=1";
    		//RedirectAttributes.addAttribute(“参数名1”，参数1)；
    		response.sendRedirect(response.encodeRedirectURL(loginUrl));  
    	} else {
    		switch (checkResult.getErrCode()) {
    			// 签名过期，返回过期提示码
    			case Constant.JWT_ERRCODE_EXPIRE:
    				CommonToolUtil.outputJson(request,response, ResponseMgr.loginExpire());
    			// 签名验证不通过
    			case Constant.JWT_ERRCODE_FAIL:
    				CommonToolUtil.outputJson(request,response, ResponseMgr.noAuth());
    			default:
    				CommonToolUtil.outputJson(request,response, ResponseMgr.err());
    		}
    	}
		 * 
		 */
	}

}

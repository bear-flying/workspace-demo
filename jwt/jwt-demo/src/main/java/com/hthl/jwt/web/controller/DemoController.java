package com.hthl.jwt.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hthl.jwt.sdk.api.ResponseMgr;
import com.hthl.jwt.sdk.api.TokenMgr;
import com.hthl.jwt.sdk.config.Constant;
import com.hthl.jwt.sdk.model.CheckResult;
import com.hthl.jwt.sdk.model.CommonResult;
import com.hthl.jwt.sdk.model.SubjectModel;
import com.hthl.jwt.sdk.utils.GsonUtil;
import com.hthl.jwt.sdk.utils.UUIDGenerator;

import io.jsonwebtoken.Claims;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception {
		System.out.println("122123");
		return "112";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public CommonResult login(HttpServletRequest request,HttpServletResponse response, String userName,String password,Model model) throws Exception {
		//*****登陆逻辑开始......结束*****
		//登陆验证通过后
		SubjectModel sub = new SubjectModel("1001", "admin");//用户信息
		String token = TokenMgr.createJWT(UUIDGenerator.getUUID(),Constant.JWT_ISS,TokenMgr.generalSubject(sub), Constant.JWT_TTL);
		CommonResult commonResult = new CommonResult(Constant.RESCODE_SUCCESS, null, "成功", token);
		return commonResult;
	}
	
	@RequestMapping(value = "/founderlogin")
	@ResponseBody
	public String founderlogin(@RequestParam String id_token, String redirect_url, Model model, 
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		//系统默认界面
		String index = "http://47.97.75.226:8080/e5workspace/Login.jsp";
		
		if (id_token == null || id_token.equals("")) {
			PrintWriter printWriter = response.getWriter();
			printWriter.print(ResponseMgr.noLogin());
			printWriter.flush();
			printWriter.close();
			return "redirect:" + index;
		}

		// 验证JWT的签名，返回CheckResult对象
		CheckResult checkResult = TokenMgr.validateJWT(id_token);
		if (checkResult.isSuccess()) {
			Claims claims = checkResult.getClaims();
			System.out.println();
			System.out.println("token校检通过checkResult：" + GsonUtil.objectToJsonStr(checkResult));
			SubjectModel user = GsonUtil.jsonStrToObject(claims.getSubject(), SubjectModel.class);
			System.out.println("token校检通过user：" + GsonUtil.objectToJsonStr(user));
			if (redirect_url != null) {
				return "redirect:" + redirect_url;
			}else{
				return "redirect:" + index;
			}
		} else {
			switch (checkResult.getErrCode()) {
				// 签名过期，返回过期提示码
				case Constant.JWT_ERRCODE_EXPIRE:
					PrintWriter printWriter = response.getWriter();
					printWriter.print(ResponseMgr.loginExpire());
					printWriter.flush();
					printWriter.close();
					break;
				// 签名验证不通过
				case Constant.JWT_ERRCODE_FAIL:
					PrintWriter printWriter2 = response.getWriter();
					printWriter2.print(ResponseMgr.noAuth());
					printWriter2.flush();
					printWriter2.close();
					break;
				default:
					break;
			}
			return "redirect:" + index;
		}
	}
}

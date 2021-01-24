package com.founder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.pojo.ResponseState;
import com.founder.pojo.Validate;
import com.founder.util.SignUtils;

@Controller
@RequestMapping("/hi")
public class HiController {

	/*
	 * AppId: 719b592852264b6a AppKey: 3aa4aeb08e62408ead1b5248bc3de799
	 */
	@RequestMapping(value = "/haha/2", method = RequestMethod.POST)
	@ResponseBody
	public ResponseState executePost2(Validate validate) {
		String appKey = "3aa4aeb08e62408ead1b5248bc3de799";
		ResponseState result = new ResponseState();
		try {
			System.out.println(validate);
			String mySign = SignUtils.retSign(validate.getAppId(), appKey, validate.getTimeStamp());
			if (mySign.equals(validate.getSign())) {
				result.setState("success");
			}
			result.setMessage("增增增增增增增增");
			System.out.println(mySign);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

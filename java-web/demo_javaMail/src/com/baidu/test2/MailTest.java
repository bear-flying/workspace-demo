package com.baidu.test2;


public class MailTest {

	public static void main(String[] args) throws Exception {
		MailSenderInfo mailInfo = new MailSenderInfo();    
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		//用户名    密码
		mailInfo.setUserName("17703592658@163.com");
		mailInfo.setPassword("lzq193016");		
		
		mailInfo.setFromAddress("17703592658@163.com");		//发送地址
		mailInfo.setToAddress("602666769@qq.com");//接收地址
		mailInfo.setSubject("两把一露头");		//主题
		mailInfo.setContent("忻州第一刀");		//内容
		
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);
		//SimpleMailSender.sendHtmlMail(mailInfo);
//		sms.sendHtmlMail(mailInfo);
		
	}
}

package com.baidu.test1;

import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo2 {

	/**
	 * @param args add by zxx ,Feb 5, 2009
	 */
	public static void main(String[] args) throws Exception{
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.sina.com");
		Session session = Session.getInstance(props,
			new Authenticator(){//在session对象中传入帐号和密码
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication("itcast_test","123456");
				}
			}
		);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("itcast_xxx@sina.com"));
		msg.setSubject("中文主题");
		//RecipientType.TO发送、CC抄送、BCC秘密抄送
		msg.setRecipients(RecipientType.TO, 
				InternetAddress.parse("itcast_test@sina.com,itcast_test@sohu.com"));
		msg.setContent("<span style='color:red'>中文呵呵呵</span>", "text/html;charset=gbk");
		Transport.send(msg);
		/**
		 * 静态方法send内部做了很多事 包括连接 发送 关闭 一体化全完成
		 * 也就意味着使用这个静态方法连接一次只发一个邮件 
		 * 并且在之前不可以调用transport.connect 否则当静态方法send内再次连接的时候会报错
		 */
		
	}

}

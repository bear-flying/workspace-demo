package com.baidu.test1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo4 {
	public static void main(String[] args) throws Exception {
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
		//发送邮件文件的办法
		Message msg = new MimeMessage(session,new FileInputStream("resouce\\demo3.eml"));
		Transport.send(msg,InternetAddress.parse("itcast_test@sohu.com"));
	}
}

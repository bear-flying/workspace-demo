package com.baidu.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public static void sendMail(String email,String content) {
		  String to = email;

	      String from = "651806859@qq.com";
	      final String username = "651806859@qq.com";//change accordingly
	      final String password = "ziyou12345.";//change accordingly



	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp."+email.substring(email.lastIndexOf("@"));

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "25");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   // Create a default MimeMessage object.
		   Message message = new MimeMessage(session);
		
		   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(from));
		
		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
		
		   // Set Subject: header field
		   message.setSubject("Testing Subject");
		
		   // Now set the actual message
		   message.setText("fg " +
			"email using JavaMailAPI "+content);

		   // Send message
		   //jar method  (main method)
		   Transport.send(message);

		   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	}

	 //ԭʼ����
	 public static void main(String[] args) {
	      // Recipient's email ID needs to be mentioned.
		 String to = "602666769@qq.com";

	      String from = "17703592658@163.com";
	      final String username = "18@163.com";//change accordingly
	      final String password = "";//change accordingly



	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.qq.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "25");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });

	      try {
		   // Create a default MimeMessage object.
		   Message message = new MimeMessage(session);
		
		   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(from));
		
		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
		
		   // Set Subject: header field
		   message.setSubject("Testing Subject");
		
		   // Now set the actual message
		   message.setText("fg " +
			"email using JavaMailAPI ");

		   // Send message
		   //jar method  (main method)
		   Transport.send(message);

		   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	         throw new RuntimeException(e);
	      }
	   }
	
	
}

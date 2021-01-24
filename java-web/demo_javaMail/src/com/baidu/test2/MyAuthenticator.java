package com.baidu.test2;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {

		String userName = null;
		String password = null;
		
		public MyAuthenticator() {
			super();
		}
		public MyAuthenticator(String userName, String password) {
			super();
			this.userName = userName;
			this.password = password;
		}
		protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(userName,password);
		}
}

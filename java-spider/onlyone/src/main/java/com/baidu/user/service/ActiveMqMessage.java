package com.baidu.user.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.MessageCreator;

public class ActiveMqMessage implements MessageCreator {

	//消息名称 保证唯一
	private String name;
	//消息内容
	private String content;
	
	//private ActiveMQTopic topic;


	@Override
	public Message createMessage(Session session) throws JMSException {

		return session.createTextMessage(content);
	
	}
	
	public ActiveMqMessage(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}

	public ActiveMqMessage() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
}

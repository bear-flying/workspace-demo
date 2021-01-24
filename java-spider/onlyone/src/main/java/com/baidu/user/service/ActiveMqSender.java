package com.baidu.user.service;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ActiveMqSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	//@Autowired
	//private ActiveMqMessage mqMessage;
	
	@Autowired
	private ActiveMQTopic topic;
	
	public void send(String name,String content){
		topic.setPhysicalName(name);
		ActiveMqMessage mqMessage = new ActiveMqMessage();
		mqMessage.setContent(content);
		//send方法需要一个MessageCreator类型的参数，而
		//ActiveMqMessage类实现了MessageCreator接口，作为子类传进来
		jmsTemplate.send(topic,mqMessage);
	}
	
}

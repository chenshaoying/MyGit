package com.blackcat.mq.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.blackcat.mq.Producer;
@Service("activeMQProducer")
public class ActiveMQProducer implements Producer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void produce(String queue, String text) {
		
		jmsTemplate.send(new ActiveMQQueue(queue), new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				msg.setText(text);
				return msg;
			}
			
		});
	}

	@Override
	public void publish(String topic, String text) {
		
		jmsTemplate.send(new ActiveMQTopic(topic), new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage();
				msg.setText(text);
				return msg;
			}
			
		});
	}

	

}

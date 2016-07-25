package com.blackcat.mq.activemq.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActiveMQListener implements MessageListener{
	private static Logger log = LoggerFactory.getLogger(ActiveMQListener.class);
	private static String BROKER_URL = "tcp://192.168.147.130:61616";
	private static String SUBJECT = "ACITVE_MQ_QUEUE_DEMO";

	public void recv() {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
		Connection conn = null;
		try {
			conn = connectionFactory.createConnection();
			conn.start();
			//创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			//创建队列
			Destination dest = session.createQueue(SUBJECT);
			//createTopic方法用来创建Topic
			//session.createTopic("TOPIC");

		    //创建mq消息的消费者  
	        MessageConsumer consumer = session.createConsumer(dest); 
	        
	        
	        ActiveMQListener self = new ActiveMQListener();
	        /*//给消费者设定监听对象  
	        consumer.setMessageListener(self); */
	        while(true) {
	        	TextMessage txtMessage = (TextMessage) consumer.receive();
	        	log.info(txtMessage.getText() + "-------------------------");
	        }
	        
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭mq连接
			if(conn != null) {
				try {
					conn.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		}

	}

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		TextMessage txtMessage = (TextMessage) msg; 
		try {
			System.out.print(txtMessage.getText());
			log.info("recv message:" + txtMessage.getText());
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

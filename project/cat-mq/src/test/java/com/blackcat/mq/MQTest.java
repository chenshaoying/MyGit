package com.blackcat.mq;

import org.junit.Test;

import com.blackcat.mq.activemq.demo.ActiveMQListener;
import com.blackcat.mq.activemq.demo.ActiveMQPublisher;
public class MQTest {
	@Test
	public void sendTest() {
		String msg = "1111我日";
		ActiveMQPublisher p = new ActiveMQPublisher();
		
		p.send(msg);
	}
	
	@Test
	public void recvTest() {
		ActiveMQListener listener = new ActiveMQListener();	
		
		listener.recv();			
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 }

package com.blackcat.mq.activemq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.blackcat.mq.Consumer;
@Service("activeMQConsumer")
public class ActiveMQConsumer implements Consumer{
	private static Logger log = LoggerFactory.getLogger(ActiveMQConsumer.class);

	@Autowired
	private JmsTemplate jmsTemplate;
	//每个consumer是singleton的，因此不需要static，保证gc正常回收
	private ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
			5,120L,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1000));
	
	@Override
	public void consume(String queue) {
		// TODO Auto-generated method stub
		String msg = (String) jmsTemplate.receiveAndConvert(queue);
		log.info("1111111111111111111111" + msg);
		/*Runnable r = new MessageHandler(msg);
		executor.execute(r);*/
	}

	@Override
	public void subscribe(String topic) {
		String msg = (String) jmsTemplate.receiveAndConvert(topic);
		Runnable r = new MessageHandler(msg);
		executor.execute(r);
	}

	
	private class MessageHandler implements Runnable {
		
		private String processCode;
		
		private MessageHandler(String processCode) {
			this.processCode = processCode;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(processCode + "11111111111111111111");
		}
		
	}

}

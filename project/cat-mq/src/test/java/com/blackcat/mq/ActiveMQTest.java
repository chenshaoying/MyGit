package com.blackcat.mq;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mq.xml"})
public class ActiveMQTest {
	
	@Resource(name="activeMQProducer")
	private Producer producer;
	
	@Resource(name="activeMQConsumer")
	private Consumer consumer;
	
	@Test
	public void produceTest() {
		
		producer.produce("queue_1","fuck you");
	}
	
	@Test
	public void consumeTest() {	
		consumer.consume("queue_1");
	}
 }

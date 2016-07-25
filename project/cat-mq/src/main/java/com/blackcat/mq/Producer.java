package com.blackcat.mq;

public interface Producer {
	
	void produce(String queue, String text);
	
	void publish(String topic, String text);
}

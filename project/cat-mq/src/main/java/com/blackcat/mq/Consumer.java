package com.blackcat.mq;

public interface Consumer {
	
	void consume(String queue);
	
	void subscribe(String topic);
}

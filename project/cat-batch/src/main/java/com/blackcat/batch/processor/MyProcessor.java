package com.blackcat.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.blackcat.frame.core.model.SysUser;

public class MyProcessor implements ItemProcessor<SysUser, SysUser>{
	private static final Logger log = LoggerFactory.getLogger(MyProcessor.class);

	@Override
	public SysUser process(SysUser item) throws Exception {
		log.info("Start processing...");
		log.info(item.getUserid());
		item.setUserna("Elsa");
		return item;
	}

	

}

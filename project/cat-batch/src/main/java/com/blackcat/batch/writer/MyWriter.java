package com.blackcat.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.blackcat.frame.core.model.SysUser;

public class MyWriter implements ItemWriter<SysUser>{
	private static final Logger log = LoggerFactory.getLogger(MyWriter.class);

	@Override
	public void write(List items) throws Exception {
		// TODO Auto-generated method stub
		log.info("start writing...");
		for(Object i: items) {
			SysUser user = (SysUser) i;
			log.info(user.getUserid() + ":" + user.getUserna());			
		}
	}

}

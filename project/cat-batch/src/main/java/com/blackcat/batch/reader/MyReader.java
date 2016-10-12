package com.blackcat.batch.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.blackcat.frame.core.model.SysUser;

public class MyReader implements ItemReader<SysUser> {
	private static final Logger log = LoggerFactory.getLogger(MyReader.class);
	private int count = 0;
	@Override
	public SysUser read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		log.info("reading......");
		SysUser user = new SysUser();
		user.setUserid(count + "");
		if(count == 10) {
			//返回空，则表示读取结束
			return null;
		}
		count++;
		return user;
	}

}

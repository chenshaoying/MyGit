package com.blackcat.frame.core.utils;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
@Service
public class RedisClient {
	 @Autowired
	 protected RedisTemplate<Serializable, Serializable> redisTemplate;
	 
	 public String getSeq(String seq_name) {
		 String seq = null;
		 seq =(Long) redisTemplate.execute(new RedisCallback<Object>() {

	            @Override
	            public Object doInRedis(RedisConnection connection) throws DataAccessException {
	            	return connection.incr(redisTemplate.getStringSerializer().serialize("seq:" + seq_name));
	            }
	        }) + "";
		 return seq; 
	 }
}

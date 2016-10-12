package com.blackcat.frame.core.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	//
	private Jedis jedis;//非切片额客户端连接 
	private static JedisPool jedisPool;//非切片连接池 
	private static JedisPoolConfig config;
	
	static {
		setConfig();
		jedisPool = new JedisPool(config,"192.168.147.130", 6379);
	}
	
	private static void setConfig() {
		config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setMaxTotal(100);
		config.setMaxWaitMillis(1000l); 
		config.setTestOnBorrow(false);
	}
	
	public RedisUtil() { 
		jedis = jedisPool.getResource(); 
	} 
	
	public void set(String key, String value) {
		jedis.set(key, value);
		
	}
}

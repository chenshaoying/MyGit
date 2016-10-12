package com.blackcat.frame.shiro.session;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.blackcat.frame.core.utils.RedisClient;

public class RedisCacheManager implements CacheManager {

	private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();
	
	@Autowired
	private RedisClient redisClient;
	
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		Cache c = caches.get(name);  
         
        /*if (c == null) {  
  
            // initialize the Redis manager instance  
        	redisClient.init();  
              
            // create a new cache instance  
            c = new RedisCache<K, V>(redisManager, keyPrefix);  
              
            // add it to the cache collection  
            caches.put(name, c);  
        }  */
        return c;  
	}

}

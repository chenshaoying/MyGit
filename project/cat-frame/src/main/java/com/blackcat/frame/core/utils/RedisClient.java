package com.blackcat.frame.core.utils;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
@Service
public class RedisClient {
	 /*@Autowired
	 protected RedisTemplate<Serializable, Serializable> redisTemplate;
	 
	 public String getSeq(String seq_name) {
		 String seq = null;
		 seq = redisTemplate.execute(new RedisCallback<Long>() {

	            @Override
	            public Long doInRedis(RedisConnection connection) throws DataAccessException {
	            	return connection.incr(stringSerialize("seq:" + seq_name));
	            }
	        }) + "";
		 return seq; 
	 }
	 
	 //common operation start
	 public void delKey(String key) {
		 redisTemplate.delete(key);
	 }
	
	 public boolean contains(String key) {
		 return redisTemplate.hasKey(key);
	 }
		 
	 //Strings operation start
	 public void addKeyString(String key,String value) {
		 redisTemplate.execute(new RedisCallback<Object>() {

	            @Override
	            public Object doInRedis(RedisConnection connection) throws DataAccessException {
	            	connection.set(stringSerialize(key), stringSerialize(value));
	            	return null;
	            }
	            
	        });
	 }
	 
	 public String getKeyString(String key) {
		 return redisTemplate.execute(new RedisCallback<String>() {

				@Override
				public String doInRedis(RedisConnection connection) throws DataAccessException {
					if(connection.exists(stringSerialize(key))) {
						return StringDeserialize(connection.get(stringSerialize(key)));
					}
					return null;
				}
				 
			 });
	 }
	 	
	 private byte[] stringSerialize(String str) {
		 //redisTemplate.getValueSerializer()
		 return redisTemplate.getStringSerializer().serialize(str);
	 }
	 
	 
	 private String StringDeserialize(byte[] b) {
		 return redisTemplate.getStringSerializer().deserialize(b);
	 }
	 
	 //Strings operation end
	 
	 //
	 //public void
	 public void addMap(String mapKey, String hashKey, String value) {
		 redisTemplate.opsForHash().put(mapKey, hashKey, value);
	 }
	 
	 public void addMap(String mapKey, Map<Object,Object> m) {
		 redisTemplate.opsForHash().putAll(mapKey, m);
	 }
	 
	 public Map<Object,Object> getMap(String mapKey) {
		 if(redisTemplate.hasKey(mapKey)) {
			 return redisTemplate.opsForHash().entries(mapKey);
		 }
		 return null;
	 }
	 
	 
	 
	 public void addObject(String key, Serializable object) {
		 redisTemplate.opsForValue().set(key, object);
	 }
	 
	 public Serializable getObject(String key) {
		 return redisTemplate.opsForValue().get(key);
	 }
	 
	 //
	 public void addList(String key, Serializable object) {
		 redisTemplate.opsForList().leftPush(key, object);
	 }
	 public void addList(String key, Serializable... values) {
		 redisTemplate.opsForList().leftPushAll(key, values);
	 }
	 
	 public Serializable getListObject(String key) {
		 return redisTemplate.opsForList().rightPop(key);
	 }
	 //
	 public void addSet(String key, Serializable... values) {
		 redisTemplate.opsForSet().add(key, values);
	 }
	 
	 //
	 public Serializable getRandomset(String key) {
		 return redisTemplate.opsForSet().randomMember(key);
	 }
	 
	 public Set<Serializable> getSetList(String key) {
		 return redisTemplate.opsForSet().members(key);
	 }
	 
	 public void removeSetMember(String key, Object... values) {
		 redisTemplate.opsForSet().remove(key, values);
	 }*/
}

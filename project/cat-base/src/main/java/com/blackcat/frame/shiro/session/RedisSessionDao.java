package com.blackcat.frame.shiro.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.blackcat.frame.core.utils.RedisClient;
public class RedisSessionDao extends CachingSessionDAO  {
	
	private static Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);
	
	private  final static String keyset = "shiro_session";
	public  final static String prefix = keyset + ":";

	@Autowired
	private RedisClient redisClient;
	
	@Override
	public Collection<Session> getActiveSessions() {
		Collection<Session> coll = new ArrayList<Session>();
		
		Set<Serializable> keys = redisClient.getSetList(keyset);
		for(Serializable k:keys) {
			Session s = (Session) redisClient.getObject(k.toString());
			coll.add(s);
		}
		
		return coll;
	}
	
	/**
	 * @return sessionId
	 */
	@Override
	protected Serializable doCreate(Session session) {
		
		Serializable sessionId = this.generateSessionId(session);
		this.assignSessionId(session, sessionId);
		
		String key = prefix + session.getId();
		/*if(redisClient.contains(key)) {
			logger.error("session already exists.");  
            return null; 
		}*/
		
		redisClient.delKey(key);
		redisClient.addObject(key, (Serializable) session);
		
		redisClient.addSet(keyset, key);
		
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		String key = prefix + sessionId;
		if(redisClient.contains(key) && redisClient.getObject(key) == null) {
			logger.error("Session not exist:" + key);
		} 
		return (Session) redisClient.getObject(key);

	}

	@Override
	protected void doUpdate(Session session) {
		if(session == null || session.getId() == null){  
            logger.error("session or session id is null");  
            return;  
        }  
		
		String key = prefix + session.getId();
		//redisClient.delKey(key);
		redisClient.addObject(key, (Serializable) session);
		
	}

	@Override
	protected void doDelete(Session session) {
		if(session == null || session.getId() == null){  
            logger.error("session or session id is null");  
            return;
        } 
		
		String key = prefix + session.getId();
		redisClient.delKey(key);
		redisClient.removeSetMember(keyset,key);
		
	}

}

package com.blackcat.frame.core.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.blackcat.frame.core.context.AppContext;
import com.blackcat.frame.core.dao.SysDictMapper;
import com.blackcat.frame.core.model.SysDict;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * @Description: 字典类
 * @author: Darren Chan
 */
public class DictUtil {
	//此方法会返回一个singleton
//	private static CacheManager cacheManager = CacheManager.create(DictUtil.class.getResource("ehcache-dict.xml"));
	//创建新的cacheManager,避免和shiro冲突（ehcache.xml中的ehcache赋予名称"dict"，默认为”_DEFAULT_“）
	private static CacheManager cacheManager = new CacheManager(DictUtil.class.getClassLoader().getResourceAsStream("ehcache-dict.xml"));
	private static Ehcache cache;
//	private static Cache cache = new Cache(new CacheConfiguration("dict",100));
	private static String prefix = "DICT_";
	private static final String CacheName = "dict";
	
	static {
		cache = cacheManager.getEhcache(CacheName);
		init();
	}
	
	private static void init() {
		SysDictMapper sysDictMapper = AppContext.getBean(SysDictMapper.class);
		List<SysDict> dicts = sysDictMapper.selectAllDistinctDicts();
		if(StrUtil.isEmptyCollection(dicts)) {
			return;
		}
		
		for(SysDict d:dicts) {
			getDict(d.getDictcd(),d.getFildcd());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> getDict(String dictcd, String fildcd, boolean all) {	
		String key = prefix + dictcd + "_" + fildcd;
		//cacheManager.getCache(key);
		if(cache.get(key) == null) {
			Map<String,String> m = getDict(dictcd, fildcd);			
			Element element = new Element(key, m);
			cache.put(element);
		} 
				
		Map<String,String> m = new LinkedHashMap<String,String>();
		if(all) {
			m.put("%", "[%]All");
		}
		Element result = cache.get(key);
		m.putAll((Map<String,String>) result.getObjectValue());		
		return m;
	}
	
	public static void editDict(SysDict sysdict) {
		SysDictMapper sysDictMapper = AppContext.getBean(SysDictMapper.class);
		sysDictMapper.updateByPrimaryKey(sysdict);
		synchronized(cache) {
			cache.remove(prefix + sysdict.getDictcd() + "_" + sysdict.getFildcd());			
		}
	}
	
	private static Map<String,String> getDict(String dictcd, String fildcd) {	
		SysDictMapper sysDictMapper = AppContext.getBean(SysDictMapper.class);
		List<SysDict> list = sysDictMapper.selectByCodeAndField(dictcd,fildcd);
		Map<String,String> m = new LinkedHashMap<String,String>();
		if(!StrUtil.isEmptyCollection(list)) {
			for(SysDict d:list) {
				m.put(d.getFildvl(), "[" + d.getFildvl() + "]" + d.getDesctx());
			}
		}		
		return m;
	}
}

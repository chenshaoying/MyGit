package com.blackcat.frame.core.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.blackcat.frame.core.context.AppContext;
import com.blackcat.frame.core.dao.SysDictMapper;
import com.blackcat.frame.core.model.SysDict;

/**
 * @Description: 字典类
 * @author: Darren Chan
 */
public class DictUtil {
	
	public static Map<String,String> getDict(String dictcd, String fildcd, boolean all) {		
		SysDictMapper sysDictMapper = AppContext.getBean(SysDictMapper.class);
		List<SysDict> list = sysDictMapper.selectByCodeAndField(dictcd,fildcd);
		Map<String,String> m = new LinkedHashMap<String,String>();
		if(all) {
			m.put("%", "[%]All");
		}
		if(!StrUtil.isEmptyCollection(list)) {
			for(SysDict d:list) {
				m.put(d.getFildvl(), "[" + d.getFildvl() + "]" + d.getDesctx());
			}
		}		
		return m;
	}
	
	public static void editDict(SysDict sysdict) {
		SysDictMapper sysDictMapper = AppContext.getBean(SysDictMapper.class);
		sysDictMapper.updateByPrimaryKey(sysdict);
	}
	
}

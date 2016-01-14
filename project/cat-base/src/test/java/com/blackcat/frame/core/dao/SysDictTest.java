package com.blackcat.frame.core.dao;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blackcat.frame.core.model.SysDict;
import com.blackcat.frame.core.utils.DictUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config.xml"})  
public class SysDictTest extends AbstractJUnit4SpringContextTests {  
    
	@Test
	public void testGetDict() {
		Map<String,String> m1 = DictUtil.getDict("common", "gender",true);
		print(m1);
		
		SysDict sysdict = new SysDict();
		sysdict.setDictcd("common");
		sysdict.setFildcd("gender");
		sysdict.setFildvl("U");
		sysdict.setDesctx("春哥");
		sysdict.setSeq(3);
		DictUtil.editDict(sysdict);
		Map<String,String> m2 = DictUtil.getDict("common", "gender",true);
		print(m2);

	}
    private void print(Map<String,String> m) {
    	StringBuffer sb = new StringBuffer();
    	for(String s:m.keySet()) {
    		sb.append(m.get(s) + " ");
    	}
    	System.out.println(sb);
    }
}

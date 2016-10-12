package com.blackcat.frame.core.utils;

import static org.junit.Assert.assertEquals;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class JoinerTest {
	@Test
	public void test1() {
		String appendable = "xx";
		//List<Integer> parts = new ArrayList<Integer>();
		
		int[] parts = {1,2 ,3 ,4 , 5};
		/*String ss = Joiner.on('|').skipNulls();
		System.out.println(ss);*/
	}
	
	@Test
	public void testMapJoiner() {
		// Using LinkedHashMap so that the original
		String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
		Map<String, String> testMap = Maps.newLinkedHashMap();
		testMap.put("Washington D.C", "Redskins");
		testMap.put("New York City", "Giants");
		testMap.put("Philadelphia", "Eagles");
		testMap.put("Dallas", "Cowboys");
		String returnedString = Joiner.on("#").withKeyValueSeparator("=").join(testMap);
		assertEquals(expectedString, returnedString);
	}
	
	@Test
	public void ttt() {
		ArrayList<Integer> list = Lists.newArrayList();
		byte[] bytes2 = "foobarbaz".getBytes(Charset.forName("UTF-8"));
	}
}

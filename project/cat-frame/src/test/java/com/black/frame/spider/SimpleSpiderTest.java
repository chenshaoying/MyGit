package com.black.frame.spider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.junit.Test;

import com.blackcat.frame.spider.SimpleSpider;

public class SimpleSpiderTest {
	
	@Test	
	public void getContentTest() {
		System.out.println(SimpleSpider.getUrlContent("http://www.zol.com.cn/"));		
	}
	
	@Test	
	public void getContentTest1() {
		System.out.println(SimpleSpider.getUrlContent1("http://www.baidu.com"));		
	}
	
	@Test	
	public void test1() {
		System.out.println(getSequences(20));		
	}
	
	public static String getSequences(int length) {
		StringBuffer seqBuffer = new StringBuffer();
		int var;
		String time = new SimpleDateFormat("yyyyMMddHHMMss").format(new Date());
		seqBuffer.append(time);
		if(length<14){
			return "";
		}else{
			for(int i=0;i<length - 14;i++){
				var = (int)(Math.random()*8.0D + 1.0D);
				seqBuffer.append(var);
			}
		}
		return seqBuffer.toString();
	}
	
	@Test
	public void test2() {
		String regex = "^[a-zA-Z_][\\w$#]*";
		String sidx = "union,select1";
		if (Pattern.matches(regex, sidx)) {
			System.out.println(1);
		} else {
			System.out.println(2);
		}
	}
}

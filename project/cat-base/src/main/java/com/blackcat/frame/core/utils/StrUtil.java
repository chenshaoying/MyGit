package com.blackcat.frame.core.utils;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

/**
 * @Description: 字符串处理工具类
 * @author: Darren Chan
 */
public class StrUtil {
	/**
	 * 字符串首字母小写
	 * @param str
	 * @return
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isLowerCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}

	/**
	 * 字符串首字母大写
	 * @param str
	 * @return
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (str == null || "".equals(str))
			return str;
		if (Character.isUpperCase(str.charAt(0)))
			return str;
		else
			return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1))
					.toString();
	}
	
	/**
	 * 字符串左补
	 * @param str
	 * @param c
	 * @param len
	 * @return
	 */
	public static String l_pad(String str, char c, int len) {
		int curr_len = str.length();
		if(curr_len >= len) {
			return str;
		}
		
		char[] array = new char[len];
		for(int i=0; i<len-curr_len; i++) {
			array[i] = c;
		}
		System.arraycopy(str.toCharArray(), 0, array, len-curr_len, curr_len);
		return new String(array);
	}
	
	/**
	 * 字符串左补
	 * @param str
	 * @param c
	 * @param len
	 * @return
	 */
	public static String l_pad_fixed_byte(String str, char c, int len, String encoding) {
		
		byte[] b = null;
		byte[] r = null;
 		try {
			b = str.getBytes(encoding);
			r = (c + "").getBytes(encoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		int curr_len = b.length;
		if(curr_len >= len) {
			return str;
		}
	
		if((len-curr_len) % (r.length) != 0 ) {
			throw new RuntimeException("长度不匹配");
		}
		
		byte[] array = new byte[len];
		
		for(int i=0; i<len-curr_len; ) {
			System.arraycopy(r,0,array,i,r.length);
			i+=r.length;			
		}
		System.arraycopy(b, 0, array, len-curr_len, curr_len);
		return new String(array);
	}
	
	public static boolean isEmptyCollection(Collection<?> c) {
		return c == null || c.size()==0;
	}
	
	public static boolean isEmptyTrim(String str) {
		return str == null || str.trim().equals("");
	}
}

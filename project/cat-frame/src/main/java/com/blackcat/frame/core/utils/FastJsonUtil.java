package com.blackcat.frame.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonUtil {
	
	public static String toJsonString(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	public static <T> T stringToObject(String text, Class<T> clazz) {
		JSONObject obj = (JSONObject) JSON.parse(text);
		
		return JSON.toJavaObject(obj, clazz);
	}
	
}

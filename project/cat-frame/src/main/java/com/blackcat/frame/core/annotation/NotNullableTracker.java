package com.blackcat.frame.core.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class NotNullableTracker {
	
	public static void NotNullableTrack(Object o, Class<?> clazz) throws NoSuchMethodException, SecurityException {
		Method m = clazz.getMethod("test1", String.class);
		
		Parameter[] p = m.getParameters();
	//	NotNullable n = m.getDeclaredAnnotation(NotNullable.class);
		NotNullable n = p[0].getDeclaredAnnotation(NotNullable.class);
		if(o == null) {
			System.out.println(n.message());
		}
	}
	
	public static void test1(@NotNullable String s) {
		
	}
	public static void main(String[] args) {
		String s = null;
		test1(s);
		
		try {
			NotNullableTrack(s,NotNullableTracker.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

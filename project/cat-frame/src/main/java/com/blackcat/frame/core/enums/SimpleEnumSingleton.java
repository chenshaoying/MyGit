package com.blackcat.frame.core.enums;
/**
 * use enum to implemnts singleton
 * @author darren
 *
 */
public enum SimpleEnumSingleton {
	instance("hello");
	
	private final String msg;
	
	//枚举的构造器只能是private
	private SimpleEnumSingleton(String msg) {
		this.msg = msg;
	}
	
	public void hello() {
		System.out.println(msg);
	}
	//Test
	public static void main(String[] args) {
		SimpleEnumSingleton.instance.hello();
	}
}

package com.blackcat.designpattern.singleton;

public enum EnumSingleton {
	instance;
	
	public void testMethod() {
		System.out.println("test");
	}
	
	//for test
	public static void main(String[] args) {
		EnumSingleton.instance.testMethod();
	}
}

package com.blackcat.designpattern.singleton;

public class HungrySingleton {
	
	private volatile static HungrySingleton instance = new HungrySingleton();
	
	private HungrySingleton() {
		
	}
	
	public static HungrySingleton getInstance() {
		return instance;
	}
}

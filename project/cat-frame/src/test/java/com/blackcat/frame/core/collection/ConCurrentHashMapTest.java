package com.blackcat.frame.core.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class ConCurrentHashMapTest {
	@Test
	public void test() {
		final Map<String, String> map = new ConcurrentHashMap<String, String>();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(map.get("1") == null) {
					System.out.println("1111");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("3333" + map.get("1"));
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				if(map.get("1") == null) {
					System.out.println("2222");
					map.put("1", "1");
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test2() {
		final Map<String, String> map = new ConcurrentHashMap<String, String>();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(map) {
					if(!map.containsKey("1")) {
						System.out.println("1111");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println("3333" + map.get("1"));
					} else {
						System.out.println("4444");
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(map) {
					if(!map.containsKey("1")) {
						System.out.println("2222");
						map.put("1", "1");
					}					
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test3() {
		final Map<String, String> map = new ConcurrentHashMap<String, String>();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(map) {
					if(!map.containsKey("1")) {
						System.out.println("1111");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						System.out.println("3333" + map.get("1"));
					} else {
						System.out.println("4444");
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				map.put("1", "1");
				System.out.println("2222");

			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

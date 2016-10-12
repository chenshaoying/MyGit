package com.blackcat.frame.core.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyLinkedListTest {
	
	@Test	
	public void addTest() {
		MyList<Integer> list = new MyLinkedList<Integer>();
		long startTime = System.currentTimeMillis();
		int i=0;
		while(i<100000) {			
			list.add(i);
			i++;
		}
		System.out.println("insert "  + "items,spend time:" + (System.currentTimeMillis() - startTime) + "ms" );
		System.out.println(list.size());
		
		long startTime2 = System.currentTimeMillis();
		List<Integer> list2 = new ArrayList<Integer>();
		int i2=0;
		while(i2<100000) {			
			list2.add(i2);
			i2++;
		}
		System.out.println("insert "  + "items,spend time:" + (System.currentTimeMillis() - startTime2) + "ms" );		
	}
	
	@Test	
	public void tetsRemove() {
		MyList<Integer> list =  prepare(10);
		print(list);
		long startTime = System.currentTimeMillis();
		list.remove(0);
		print(list);
		System.out.println("remove "  + "items,spend time:" + (System.currentTimeMillis() - startTime) + "ms" );
	}
	
	@Test	
	public void tetsContains() {
		MyList<Integer> list =  prepare(10000);
		//print(list);
		long startTime = System.currentTimeMillis();
		boolean flag =  list.contains(999);		
		System.out.println(flag + ":" + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	
	private MyList<Integer> prepare(int size) {
		MyList<Integer>list = new MyLinkedList<Integer>();
		int i=0;
		while(i<size) {			
			list.add(i);
			i++;
		}
		return list;
	}
	
	private void print(MyList<Integer> list) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<list.size()-1;i++) {
			sb.append(list.get(i) + ",");		
		}
		if(list.size() > 0 ) {
			sb.append(list.get(list.size()-1));			
		}
		System.out.println(sb);
	}
}

package com.blackcat.frame.core.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyArrayListTest {
	
	@Test	
	public void addTest() {
		MyList<Integer> list = new MyArrayList<Integer>();
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
		MyList<Integer> list =  prepare(1);
		print(list);
		long startTime = System.currentTimeMillis();
		list.remove(Integer.valueOf(2));
		print(list);
		System.out.println("remove "  + "items,spend time:" + (System.currentTimeMillis() - startTime) + "ms" );
	}
	
	
	private MyList<Integer> prepare(int size) {
		MyList<Integer>list = new MyArrayList<Integer>();
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
		sb.append(list.get(list.size()-1));
		System.out.println(sb);
	}
}

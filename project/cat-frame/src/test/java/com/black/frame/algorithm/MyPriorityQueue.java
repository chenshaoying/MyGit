package com.black.frame.algorithm;

import java.util.Random;

import org.junit.Test;

public class MyPriorityQueue {
	
	private static int default_size = 10;
	private int[] items;
	private int size;
	private int head;
	
	public MyPriorityQueue() {
		items = new int[default_size];
		size = 0;
		head = -1;
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(int e) {
		if(size == items.length) {
			int[] newItem = new int[items.length*2 + 1];
			System.arraycopy(items, 0, newItem, 0, size);
			items = newItem;
		}
		int i = head + 1;
		while(i>0 && items[i-1] > e) {
			items[i] = items[i-1];
			i--;
		}
		items[i] = e;
		size++;
		head++;
	}
	
	public Integer poll() {
		if(isEmpty()) {
			return  null;
		}
		size--;
		return items[head--];
	}
	
	public Integer peek() {
		if(isEmpty()) {
			return  null;
		}
		return items[head];
	}
	
	@Test
	public void test1() {
		MyPriorityQueue queue = new MyPriorityQueue();
		Random r = new Random();
		for (int i = 0; i < 25; i++) {
			queue.add(r.nextInt(1000));
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		
	}
}

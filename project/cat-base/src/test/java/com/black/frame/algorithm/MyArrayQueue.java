package com.black.frame.algorithm;

import org.junit.Test;

public class MyArrayQueue {
	
	private static int default_size = 10;
	private int[] items;
	private int size;
	private int head;
	private int tail;
	
	public MyArrayQueue() {
		items = new int[default_size];
		size = 0;
		head = -1;
		tail = -1;
	}
	
	
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object o) {
		if(isEmpty()) {
			return false;
		}
		return false;
	}

	
	public int[] toArray() {
		int[] newItems = new int[size];
		if(items.length > size + head - 1) {
			System.arraycopy(items, head, newItems, 0, size);			
		} else {
			System.arraycopy(items, head, newItems, 0, items.length - head);	
			System.arraycopy(items, 0, items, items.length - head, size - items.length + head);
		}
		return newItems;
	}

	
	public void clear() {
		items = new int[default_size];
		size = 0;
		head = 0;	
	}

	public boolean add(Integer e) {
		if(size == items.length) {
			int[] newItems = new int[items.length * 2 + 1];
			if(items.length > size + head - 1) {
				System.arraycopy(items, head, newItems, 0, size);			
			} else {
				System.arraycopy(items, head, newItems, 0, items.length - head);	
				System.arraycopy(items, 0, newItems, items.length - head, size - items.length + head);
			}
			items = newItems;
			head = 0;
			tail = size-1;
		}
		if(tail < items.length-1) {
			tail++;
		} else {
			tail = 0;
		}
		
		items[tail] = e;
		if(head == -1) {
			head = 0;
		}
		size++;
		return true;
	}


	public Integer poll() {
		if(isEmpty()) {
			return null;
		}
		int tmp = items[head];
		if(head == items.length-1) {
			head = 0;
		} else {
			head++;
		}
		size--;
		return tmp;
	}

	public Integer peek() {
		if(isEmpty()) {
			return null;
		}
		int tmp = items[head];
		return tmp;
	}

	@Test
	public void test1() {
		MyArrayQueue queue = new MyArrayQueue();
		for (int i = 0; i < 5; i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		for (int i = 5; i < 20; i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	
	
}

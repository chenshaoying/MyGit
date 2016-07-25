package com.black.frame.algorithm;

import java.util.Random;

import org.junit.Test;

public class MinStack {
	
	private Node[] items;
	private int size;
	private int p_min;
	
	public MinStack() {
		items = new Node[10];
		size = 0;
		p_min = 0;
	}
	
	public void push(int i) {
		if(size == items.length) {
			Node[] tmp = new Node[items.length*2 + 1];
			System.arraycopy(items, 0, tmp, 0, items.length);
			items = tmp;
		}	
		if(size == 0) {
			Node n = new Node(i,0);
			p_min = 0;
			items[size++] = n;
		} else {
			//当且仅当push的值小于原来最小值的坐标时，才改变最小坐标的值，保证最小坐标一直在最左侧
			if(items[p_min].val > i) {
				Node n = new Node(i,p_min);
				p_min = size;
				items[size++] = n;
			} else {
				Node n = new Node(i,p_min);
				items[size++] = n;
			}
		}		
	}
	
	public int pop() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		Node n = items[--size];
		
		if(size == p_min) {
			p_min = n.pre_min_idx;
		}
		
		return n.val;
	}
	
	public int min() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		return items[p_min].val;
	}
	
	
	private class Node {
		int val;
		int pre_min_idx;
		
		private Node(int val, int pre_min_idx) {
			this.val = val;
			this.pre_min_idx = pre_min_idx;
		}
	}
	
	@Test
	public void test1() {
		MinStack m = new MinStack();
		int num = 20;
		int c = 0;
		while(c < num) {
			Random r = new Random();
			int i = r.nextInt(10);
			System.out.print(i + "  ");
			m.push(i);
			c++;
		}
		System.out.println("");
		
		while(c != 1) {
			System.out.print(m.pop() + ":" + m.min() + "  ");
			c--;
		}
	}
	
}

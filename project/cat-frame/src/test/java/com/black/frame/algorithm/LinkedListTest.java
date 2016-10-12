package com.black.frame.algorithm;

import org.junit.Test;

public class LinkedListTest {
	
	public Node gen() {
		Node head = new Node(1);
		Node cur = head;
		while(cur.val != 3) {
			Node n = new Node(cur.val + 1);
			cur.next = n;
			cur = n;
		}
		return head;		
	}
	
	public void print(Node head) {
		Node cur = head;
		StringBuffer sb = new StringBuffer();
		while(cur != null) {
			sb.append(cur.val + " ");
			cur = cur.next;
		}
		System.out.println(sb.toString());
	}
	
	public Node swap(Node head, int left, int right) {
		
		Node a = head;
		Node b = head;
		
		int count = 0;
		Node cur = head;
		while(cur != null && (count <= left || count <= right)) {
			if(count == left) {
				a = cur;
			}			
			if(count == right) {
				b = cur;
			}
			
			cur = cur.next;
			count++;
		}
		
		int tmp = a.val;
		a.val = b.val;
		b.val = tmp;
		
		return head;
	}
	
	public Node oddEvenList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node cur = head;
		Node ptr = head.next;
		Node p = ptr.next;
		
		int cnt = 3;
		while(p != null) {
			if(cnt % 2 == 1) {
				Node t1 = p.next;
				p.next = cur.next;
				cur.next = p;
				ptr.next = t1;
				
				cur = cur.next;
			} else {
				ptr = ptr.next;
				p = ptr.next;				
			}
			cnt++;
			print(head);
		}
		return head;
	}
	
	@Test
	public void testSwap() {
		Node head = gen();
		print(head);
		
		head = swap(head, 0, 1);
		print(head);
	}
	
	@Test
	public void testoddEvenList() {
		Node head = gen();
		print(head);
		
		head = oddEvenList(head);
		print(head);
	}
	
	
	
	
	
	
	private class Node {
		int val;
		Node next;
		public Node(int n) {
			this.val = n;
		}
	}
}

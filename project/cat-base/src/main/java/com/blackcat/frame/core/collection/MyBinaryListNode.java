package com.blackcat.frame.core.collection;

class MyBinaryListNode<T extends Comparable<?>> {
	T val;
	MyBinaryListNode<T> left;
	MyBinaryListNode<T> right;
	
	public MyBinaryListNode(T val, MyBinaryListNode<T> left, MyBinaryListNode<T> right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

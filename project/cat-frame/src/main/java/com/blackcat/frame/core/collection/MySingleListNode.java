package com.blackcat.frame.core.collection;

class MySingleListNode<T> {
	T val;
	MySingleListNode<T> next;
	MySingleListNode(T t, MySingleListNode<T> next) {
		this.val = t;
		this.next = next;
	}
}

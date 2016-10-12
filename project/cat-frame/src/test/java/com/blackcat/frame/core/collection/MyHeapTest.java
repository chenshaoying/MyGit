package com.blackcat.frame.core.collection;

import org.junit.Test;

public class MyHeapTest {
	@Test
	public void testInsert() {
		MyHeap<Person> heap = new MyHeap<Person>(10);
		for (int i = 0; i < 10; i++) {
			Person p = new Person(i, i + "man");
			heap.insert(p);
		}
		heap.print();
	}
}

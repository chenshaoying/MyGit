package com.blackcat.frame.core.collection;

public interface MyCollection<T> {
	int size();

	boolean isEmpty();

	void clear();

	boolean contains(T t);

	boolean add(T t);

	boolean remove(T t);
}

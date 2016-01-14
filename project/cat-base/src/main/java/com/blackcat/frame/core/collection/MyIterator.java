package com.blackcat.frame.core.collection;

public interface MyIterator<T> {
	boolean hasNext();
	
	T next();
	
	void remove();
}

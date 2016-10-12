package com.blackcat.frame.core.collection;

public interface MyList<T> extends MyCollection<T> {

	T get(int idx);
	
	void set(int idx, T t);
	
	T remove(int idx);
		
}

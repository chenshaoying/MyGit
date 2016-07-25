package com.blackcat.frame.core.collection;

public class MyArrayList<T> implements MyList<T>{
	private T[] array;
	private static final int default_length = 20; 
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (T[]) new Object[default_length];
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array = (T[]) new Object[default_length];
		size = 0;
	}

	@Override
	public boolean contains(T t) {
		for(int i=0;i<size;i++) {
			if((t==null && array[i] == null) || (t != null && t.equals(array[i]))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(T t) {
		ensureCapacityInternal();
		array[size++] = t; 
		return true;
	}

	@Override
	public  T remove(T t) {
		T re = null;
		for(int i=0;i<size;i++) {
			if((t==null && array[i] == null) || (t != null && t.equals(array[i]))) {
				    re = array[i];
					System.arraycopy(array, i+1, array, i, size-i-1);
					array[--size] = null;					
			} 
		}
		return re;
	}

	@Override
	public T get(int idx) {
		if(idx < size) {
			return array[idx];			
		} else {
			return null;
		}
	}

	@Override
	public void set(int idx, T t) {
		if(idx < size) {
			array[idx] = t;
		} else {
			throw new IndexOutOfBoundsException("Index: "+idx+", Size: "+this.size);
		}
	}

	@Override
	public T remove(int idx) {
		T re = null;
		if(idx < size) {
			re = array[idx];
			System.arraycopy(array, idx+1, array, idx, size-idx-1);
			array[--size] = null;
		} else {
			throw new IndexOutOfBoundsException("Index: "+idx+", Size: "+this.size);
		}
		return re;
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacityInternal() {
		if(size == array.length) {
			T[] temp = (T[]) new Object[size*2 + 1];
			System.arraycopy(array, 0, temp, 0, size);
			array = temp;
		}
	}
}

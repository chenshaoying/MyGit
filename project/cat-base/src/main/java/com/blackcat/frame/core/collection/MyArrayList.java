package com.blackcat.frame.core.collection;

public class MyArrayList<T> implements MyList<T>{
	private T[] array;
	private static final int default_length = 20; 
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (T[]) new Object[default_length];
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
		if(t == null) {
			for(T c:array) {
				if(c==null) {
					return true;
				}
			}
		} else {
			for(T c:array) {
				if(t.equals(c)) {
					return true;
				}
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
	public boolean remove(T t) {
		for(int i=0;i<size;) {
			if(t==null) {
				if(array[i]==null) {
					System.arraycopy(array, i+1, array, i, size-i-1);
					array[--size] = null;					
				} else {
					i++;
				}
			} else {
				if(t.equals(array[i])) {
					System.arraycopy(array, i+1, array, i, size-i-1);
					array[--size] = null;					
				} else {
					i++;
				}
			}
		}
		return false;
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
	public void remove(int idx) {
		if(idx < size) {
			System.arraycopy(array, idx+1, array, idx, size-idx-1);
			array[--size] = null;
		} else {
			throw new IndexOutOfBoundsException("Index: "+idx+", Size: "+this.size);
		}
		
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacityInternal() {
		if(size == array.length-1) {
			T[] temp = (T[]) new Object[size*2 + 1];
			System.arraycopy(array, 0, temp, 0, size);
			array = temp;
		}
	}
}

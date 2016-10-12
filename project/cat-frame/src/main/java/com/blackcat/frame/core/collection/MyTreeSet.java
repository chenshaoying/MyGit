package com.blackcat.frame.core.collection;

public class MyTreeSet<T  extends Comparable<?>> implements MySet<T>{
	private MyBinaryListNode<T> root;
	private int size;
	public MyTreeSet() {
		this.root = null;
		size = 0 ;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		this.root = null;
		size = 0 ;
	}

	
	@Override
	public  boolean contains(T t) {
		// TODO Auto-generated method stub
		if(root == null || t == null) {
			return false;
		}
		/*if(t instanceof Comparable) {
			t.compareTo(root.val);
			int i =  root.val.compareTo(t);
			
		}*/
		//t.compareTo(root.val);
		return true;
	}

	@Override
	public boolean add(T t) {
		if(isEmpty()) {
			root = new MyBinaryListNode<T>(t,null,null);
		}
	//	if(t.compareTo(root.val)> 0)
		return true;
	}

	@Override
	public T remove(T t) {
		// TODO Auto-generated method stub
		return t;
	}
	
	

}

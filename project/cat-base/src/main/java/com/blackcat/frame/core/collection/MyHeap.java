package com.blackcat.frame.core.collection;

import com.google.common.base.Joiner;

public class MyHeap<T extends Person> {
	private Object[] array;
	private int maxSize;
	private int curSize;
	
	public  MyHeap(int maxSize) {
		this.array = new Object[maxSize];
		this.maxSize = maxSize;
		this.curSize = 0;
	}
	
	public boolean insert(T t) {
		if(curSize == maxSize) {
			return false;
		}
		array[curSize] = t;
		trickleUp(curSize++);
		return true;
	}
	
	//移除根节点
	public boolean remove() {
		if(isEmpty()) {
			return false;
		}
		array[0] = array[--curSize];		
		trickleDown(0);
		return true;
	}
	
	public boolean isEmpty() {
		return curSize == 0;
	}
	@SuppressWarnings("unchecked")
	private void trickleUp(int idx) {
		T bottom = (T) array[idx];
		int parent = (idx-1)/2;
				
		while(idx > 0 && ((T) array[parent]).id < bottom.id) {
			array[idx] = array[parent];
			idx = parent;
			parent = (parent-1)/2;
		}
		array[idx] = bottom;
	}
	//先把最小的移到根节点位置
	//然后把这个值往下移到大于他的值的节点之下，小雨他的值的节点之上。
	@SuppressWarnings("unchecked")
	private void trickleDown(int idx) {
		//bottom to top
		int largeChild;
		T top = (T) array[idx];
		while(idx < curSize/2) {    //保证至少有一个子节点
			int leftChild = idx*2 + 1;
			int rightChild = leftChild + 1;
			if(rightChild < curSize && ((T) array[rightChild]).id > ((T) array[leftChild]).id) {
				largeChild = rightChild;
			} else {
				largeChild = leftChild;
			}
			if(((T) array[largeChild]).id < top.id) {
				break;
			}
			array[idx] = array[largeChild];
			idx = largeChild;
		}
		array[idx] = top;
	}
	
	public void print() {
		System.out.println(Joiner.on(";").skipNulls().join(array));
	}
}

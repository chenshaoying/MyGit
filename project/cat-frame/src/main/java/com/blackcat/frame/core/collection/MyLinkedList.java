package com.blackcat.frame.core.collection;

public class MyLinkedList<T> implements MyList<T> {
	
	private int size ;
	private MySingleListNode<T> head;
	private MySingleListNode<T> tail;

	
	public MyLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(T t) {
		if(t == null) {
			MySingleListNode<T> start = head;
			while(start !=null) {
				if(start.val == null) {
					return true;
				}
				start = start.next;
			}			
		} else {
			MySingleListNode<T> start = head;
			while(start !=null) {
				if(t.equals(start.val)) {
					return true;
				}
				start = start.next;
			}
		}
		return false;
	}

	@Override
	public boolean add(T t) {
		if(head == null) {
			head = new MySingleListNode<T>(t,null);
			tail = head;
		} else {			
			tail.next = new MySingleListNode<T>(t,null);
			tail = tail.next;
		}
		size++;
		return true;
	}

	@Override
	public T remove(T t) {
		T re = null;
		MySingleListNode<T> pre = null;
		MySingleListNode<T> cur = head;
		while(cur != null) {
			if((t == null && cur.val == null) || (t != null && t.equals(cur.val))) {
				re = cur.val;
				pre.next = cur.next;
				size--;
				break;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return re;
	}

	@Override
	public T get(int idx) {
		if(idx < size && idx > -1) {
			int count = 0;
			MySingleListNode<T> curr = head;
			while(count != idx) {
				curr = curr.next;
				count++;
			}
			return curr.val;
		}
		return null;
	}

	@Override
	public void set(int idx, T t) {
		if(idx < size && idx > -1) {
			int count = 0;
			MySingleListNode<T> curr = head;
			while(count != idx) {
				curr = curr.next;
				count++;
			}
			curr.val = t;
		} else {
			throw new IndexOutOfBoundsException("index :" + idx + ",size:" + size);
		}
	}

	@Override
	public T remove(int idx) {
		T re = null;
		if(idx < size && idx > -1) {
			int count = 0;
			MySingleListNode<T> pre = null;
			MySingleListNode<T> cur = head;
			while(count != idx) {
				pre = cur;
				cur = cur.next;
				count++;
			}
			re = cur.val;
			if(pre != null) {
				pre.next = cur.next;				
			} else {
				head = head.next;
			}
			size--;
		} else {
			throw new IndexOutOfBoundsException("index :" + idx + ",size:" + size);
		}
		return re;
	}
	
}

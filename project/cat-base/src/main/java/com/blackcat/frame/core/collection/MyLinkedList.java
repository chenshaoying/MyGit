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
	public boolean remove(T t) {
		if(head != null) {
			MySingleListNode<T> curr_prev = head;
			MySingleListNode<T> curr = head.next;
			
			if(t == null) {
				if(head.val == null) {
					head = head.next;
					size--;
					if(size == 0) {
						tail = null;
					}
					return true;
				}
				while(curr != null) {
					if(curr.val == null) {
						if(tail == curr) {
							tail = curr_prev;
						} 
						curr_prev.next = curr.next;
						size--;
						return true;
					} else {
						curr_prev = curr;
						curr = curr.next;
					}
				}
			} else {
				if(t.equals(head.val)) {
					head = head.next;
					size--;
					if(size == 0) {
						tail = null;
					}
					return true;
				}
				while(curr != null) {
					if(t.equals(curr.val)) {
						if(tail == curr) {
							tail = curr_prev;
						}
						curr_prev.next = curr.next;
						size--;
						return true;
					} else {
						curr_prev = curr;
						curr = curr.next;
					}
				}
			}
		} 
		return false;
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
	public void remove(int idx) {
		if(idx < size && idx > -1) {
			int count = 0;
			MySingleListNode<T> curr = head;
			MySingleListNode<T> curr_prev = null;
			while(count != idx) {
				curr_prev = curr;
				curr = curr.next;
				count++;
			}
			if(curr_prev != null) {
				curr_prev.next = curr.next;				
			} else {
				head = head.next;
			}
			if(count == size-1) {
				tail = curr_prev;
			}
			size--;
		} else {
			throw new IndexOutOfBoundsException("index :" + idx + ",size:" + size);
		}
		
	}
	
}

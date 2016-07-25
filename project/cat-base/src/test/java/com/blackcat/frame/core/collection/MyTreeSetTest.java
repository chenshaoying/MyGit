package com.blackcat.frame.core.collection;

import org.junit.Test;

public class MyTreeSetTest {
	@Test
	public void test1() {
		MyTreeSet<Comp> m = new MyTreeSet<Comp>();
		
	}
}

class Comp  implements Comparable<Comp> {

	private int id;
	
	public Comp(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	@Override
	public int compareTo(Comp e) {
		if(this.id > e.getId()) {
			return 1;
		} else if (this.id < e.getId()) {
			return -1;
		}
		return 0;
	}
	
}

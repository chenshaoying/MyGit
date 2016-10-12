package com.black.frame.spider;

import org.junit.Test;

public class SimpleSpiderTest2 {
	@Test
	public void test1() {
		Person1 p1 = new Person1("A", 1);
		Person1 p2 = new Person1("B", 2);
		
		Group1 g = new Group1(p1, p2);
		
		Person1 p11 = g.getP1();
		/*p11.setAge(11);
		p11.setName("AA");
		System.out.println(g.getP1().getAge() + g.getP1().getName());
		System.out.println(p1.getAge() + p1.getName());*/
		
		String s = p11.name;
		s = "XX";
		System.out.println(p11.name);
		
		p11.age = 1111;
		System.out.println(p11.age);
	}
}

class Group1 {
	private Person1 p1;
	public Person1 p2;
	
	public Group1(Person1 p1, Person1 p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	public Person1 getP1() {
		return p1;
	}
	public void setP1(Person1 p1) {
		this.p1 = p1;
	}
}
class Person1 {
	public String name;
	public int age;
	
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
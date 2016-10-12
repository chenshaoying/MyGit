package com.blackcat.frame.core.collection;

import java.util.Random;

import com.google.common.base.Joiner;

public class MyHashTable {
	private Person[] array;
	private static int DEFAULT_SIZE = 20;
	private int size;
	public MyHashTable() {
		array = new Person[DEFAULT_SIZE];
		size = 0;
	}
	
	public void insert(Person p) {
		int hashVal = hash(p.id);
		array[hashVal] = p;
		size ++;
	}
	
	public int hash(int key) {
		int hashVal = key % array.length;
		while(hashVal >= array.length) {
			hashVal %= array.length;
		}
		while(array[hashVal] != null) {
			hashVal++;
			hashVal %= array.length;
		}
		return hashVal;
	}
	
	public void print() {
		System.out.println(Joiner.on("\n").useForNull("null").join(array));
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		MyHashTable m = new MyHashTable();
		for(int i=0; i < 10; i++) {
			Person p = new Person(r.nextInt(100), i + "");
			m.insert(p);
		}
		m.print();
	}
}

class Person {
	int id;
	String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.id + ":" + this.name;
	}
}

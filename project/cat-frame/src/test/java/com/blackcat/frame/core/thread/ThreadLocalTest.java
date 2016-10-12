package com.blackcat.frame.core.thread;

import java.util.Random;

public class ThreadLocalTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread( new TlRunner(), "t1");
		Thread t2 = new Thread( new TlRunner(), "t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}

class TheadLocalClass {
	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>();
	
	public void set(int i) {
		local.set(i);
	}
	
	public int get() {
		return local.get();
	}
}

class TlRunner implements Runnable {
	private TheadLocalClass clz;
	public TlRunner() {
		this.clz = new TheadLocalClass();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int i = r.nextInt(10);
		System.out.println(Thread.currentThread().getName() + i);

		clz.set(i); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + clz.get());
	}
	
}
package com.blackcat.frame.core.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class LockTestTwo {
	@Test
	public void test1() {
		LockRunner runner = new LockRunner();
		Runnable task = new Runnable() {

			@Override
			public void run() {
				int j = 0;
				while(j < 10) {
					runner.increase();
					j++;
				}
			}
			
		};
		
		Thread t1 = new Thread(task, "t1");
		Thread t2 = new Thread(task, "t2");
		t1.start();
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(runner.getNum());
	}
	
	@Test
	public void test2() {
		TryLockRunner2 runner = new TryLockRunner2();
		Runnable task = new Runnable() {

			@Override
			public void run() {
				int j = 0;
				while(j < 10) {
					runner.increase();
					j++;
				}
			}
			
		};
		
		Thread t1 = new Thread(task, "t1");
		Thread t2 = new Thread(task, "t2");
		t1.start();
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(runner.getNum());
	}
}

class LockRunner {
	private Lock lock;
	private int i;
	public LockRunner() {
		lock = new ReentrantLock();
		i = 0;
	}
	
	public void increase() {
		lock.lock();
		try {
			i++;
			System.out.println(Thread.currentThread().getName() + "||" + i);
		} finally {
			lock.unlock();
		}
	}
	
	public int getNum() {
		return i;
	}
}

class TryLockRunner2 {
	private Lock lock;
	private int i;
	public TryLockRunner2() {
		lock = new ReentrantLock();
		i = 0;
	}
	
	public void increase() {
		if(lock.tryLock()) {
			try {
				i++;
				System.out.println(Thread.currentThread().getName() + "||" + i);
			} finally {
				lock.unlock();
			}			
		} else {
			System.out.println(Thread.currentThread().getName() + " try lock fail");
		}
	}
	
	public int getNum() {
		return i;
	}
}
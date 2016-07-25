package com.blackcat.frame.core.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class ConditionTest {
	@Test
	public void test1() {
		WaterPool pool = new WaterPool();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					pool.incr();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					pool.decr();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pool.getNum());
	}
 }

class WaterPool {
	private Lock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	private int i = 0;
	
	public void incr() throws InterruptedException {
		lock.lock();
		try {
			System.out.println("incr:1 " + Thread.currentThread().getName());
			while(i > 10) {
				notFull.await();	
			}
			System.out.println("incr:2 " + Thread.currentThread().getName());

			i++;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
		
	}
	
	public void decr() throws InterruptedException {
		lock.lock();
		try {
			System.out.println("decr1: " + Thread.currentThread().getName());
			while(i == 0) {
				notEmpty.await();	
			}
			System.out.println("decr2: " + Thread.currentThread().getName());

			i--;
			notFull.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public int getNum() {
		return i;
	}
}
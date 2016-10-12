package com.blackcat.frame.core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class LockTest {
	@Test
	public void test1() {
		LockRunner1 r = new LockRunner1(0);
		Thread t1 = new Thread(r,"t1");
		Thread t2 = new Thread(r,"t2");
		t1.start();
		t2.start();
	}

	@Test
	public void test2() {
		Lock lock = new ReentrantLock();
		LockRunner2 r = new LockRunner2(0,lock);
		Thread t1 = new Thread(r,"t1");
		Thread t2 = new Thread(r,"t2");
		t1.start();
		t2.start();
		
		//房子主线程退出后，子线程立即被终止
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.interrupt();
		System.out.println("----------");
	}
	
	@Test
	public void test3() {
		Lock lock = new ReentrantLock();
		TryLockRunner r = new TryLockRunner(0,lock);
		Thread t1 = new Thread(r,"t1");
		Thread t2 = new Thread(r,"t2");
		t1.start();
		t2.start();
		
		//房子主线程退出后，子线程立即被终止
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------");
	}
	
	@Test
	public void test4() {
		Lock lock = new ReentrantLock();
		Runnable r = new LockInterruptRunner(0,lock);
		Thread t1 = new Thread(r,"t1");
		Thread t2 = new Thread(r,"t2");
		t1.start();
		t2.start();
		
		//房子主线程退出后，子线程立即被终止
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------");
	}
}

class LockRunner1 implements Runnable {
	private int i;
	public LockRunner1(int i) {
		this.i = i;
	}
	@Override
	public void run() {
		Lock lock = new ReentrantLock();//局部变量每个线程都会自建一个lock锁，因此失败
		lock.lock();
		try {
			while(i<20) {
				System.out.println(Thread.currentThread().getName() + ":" +  (i++));						
			}			
		} finally {
			lock.unlock();			
		}
	}
}

class LockRunner2 implements Runnable {
	private int i;
	private Lock lock;
	public LockRunner2(int i, Lock lock) {
		this.i = i;
		this.lock = lock;
	}
	@Override
	public void run() {
		lock.lock();
		try {
			while(i<20) {
				System.out.println(Thread.currentThread().getName() + ":" +  (i++));						
			}			
		} finally {
			lock.unlock();			
		}
	}
}

class TryLockRunner implements Runnable {
	private int i;
	private Lock lock;
	public TryLockRunner(int i, Lock lock) {
		this.i = i;
		this.lock = lock;
	}
	@Override
	public void run() {
		if(lock.tryLock()) {
			try {
				while(i<20) {
					System.out.println(Thread.currentThread().getName() + ":" +  (i++));						
				}			
			} finally {
				lock.unlock();			
			}			
		} else {
			System.out.println(Thread.currentThread().getName() + ":失败" );						
		}
	}
}

class LockInterruptRunner implements Runnable {
	private int i;
	private Lock lock;
	public LockInterruptRunner(int i, Lock lock) {
		this.i = i;
		this.lock = lock;
	}
	@Override
	public void run() {
		try {
			/*lockInterruptibly()方法比较特殊，当通过这个方法去获取锁时，
			如果线程正在等待获取锁，则这个线程能够响应中断，即中断线程的等待状态。
			也就使说，当两个线程同时通过lock.lockInterruptibly()想获取某个锁时，
			假若此时线程A获取到了锁，而线程B只有在等待，
			那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程。*/
			/*注意，当一个线程获取了锁之后，是不会被interrupt()方法中断的。因为本身在前面的文章中讲过单独调用interrupt()方法不能中断正在运行过程中的线程，只能中断阻塞过程中的线程。
			因此当通过lockInterruptibly()方法获取某个锁时，如果不能获取到，只有进行等待的情况下，是可以响应中断的。
			而用synchronized修饰的话，当一个线程处于等待某个锁的状态，是无法被中断的，只有一直等待下去。*/
			lock.lockInterruptibly();
			while(i<20) {
				if(i == 15) {
					System.out.println(Thread.currentThread().getName());
					Thread.interrupted();
				}
				System.out.println(Thread.currentThread().getName() + ":" +  (i++));						
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + ":interrupt" );						
		} finally {
			lock.unlock();			
		}
		
	}
}
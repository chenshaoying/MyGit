package com.blackcat.frame.core.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class ReadWriteLockTest {
	@Test
	public void test1() {
		File pool = new File();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					pool.read();					
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					pool.write(i);					
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
		
		//System.out.println(pool.getNum());
	}
}

class File {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private int i;
	
	public int read() {
		Lock rl = lock.readLock();
		rl.lock();
		int ret;
		try {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			ret = i;
		} finally {
			rl.unlock();
		}
		return ret;
	}
	
	public void write(int num) {
		Lock wl = lock.writeLock();
		wl.lock();
		try {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			this.i = num;			
		} finally {
			wl.unlock();
		}
	}

}
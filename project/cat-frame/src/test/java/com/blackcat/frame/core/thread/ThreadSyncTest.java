package com.blackcat.frame.core.thread;

public class ThreadSyncTest {
	
	public static void main(String[] args) {
		//Object lock = new Object();
		SyncMethodThread t = new SyncMethodThread();
		Thread t1 = new Thread(t,"t1");
		Thread t2 = new Thread(t,"t2");
		t1.start();
		
		t2.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
 }



class SyncThread implements Runnable {
	private static Object lock = new Object();
	
	@Override
	public void run() {
		synchronized(lock) {
			int i = 0;
			while(i < 10) {
				System.out.println(Thread.currentThread().getName() + ":" + i);	
				i++;
			}
		}		
	}	
}

class SyncMethodThread implements Runnable {
		
	@Override
	public void run() {
		print();
	}	
	
	private synchronized void print() {
		int i = 0;
		while(i < 10) {
			System.out.println(Thread.currentThread().getName() + ":" + i);	
			i++;
		}
	}
}

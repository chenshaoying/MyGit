package com.blackcat.frame.core.thread;

import java.util.concurrent.TimeUnit;

public class ThreadNoticeTest {
	
	public static void main(String[] args) {
		Object lock = new Object();		
		Thread t1 = new Thread(new WaitThread(lock),"t1");
		Thread t2 = new Thread(new NoticeThread(lock),"t2");
		
		Thread t3 = new Thread(new WaitThread(lock),"t3");

		t1.start();		
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		
	}
	
	
 }



class WaitThread implements Runnable {
	private  Object lock;
	public static boolean flag = false;
	public WaitThread(Object lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		synchronized(lock) {
			if(!flag) {
				try {
					System.out.println(Thread.currentThread().getName() + "I'm first !");
					lock.wait();
					System.out.println(Thread.currentThread().getName() + "wwwwwwwwwake up!");
					//如果这里不notify的话其他wait线程将会一直wait
					//lock.notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName() + "no waiting!");
			}
		} 
	}	
}


class NoticeThread implements Runnable {
	private  Object lock;
	public NoticeThread(Object lock) {
		this.lock = lock;
	}
	@Override
	public void run() {
		synchronized(lock) {
			//notify 会再当前线程执行完毕后再去释放锁
			System.out.println(Thread.currentThread().getName() + "I'm notify !");
			lock.notifyAll();	
			WaitThread.flag = true;
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("you may go");
		}
	}	
}



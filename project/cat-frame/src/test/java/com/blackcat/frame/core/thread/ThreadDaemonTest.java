package com.blackcat.frame.core.thread;

public class ThreadDaemonTest {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner(),"t1");
		//如果设置为后台守护线程，当main函数执行完成后，java虚拟机退出，后台线程不管执行情况如何，也退出
		t1.setDaemon(true);
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());

	}
	
	private static class Runner implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			
		}	
	}
 }

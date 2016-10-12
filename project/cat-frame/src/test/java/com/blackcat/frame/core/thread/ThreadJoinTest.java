package com.blackcat.frame.core.thread;

public class ThreadJoinTest {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Joinner(Thread.currentThread()),"t1");
		Thread t2 = new Thread(new Joinner(t1),"t2");
		t1.start();
		t2.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//先start 再join
		Thread t3 = new Thread(new Runner(),"t3");
		t3.start();
		try {
			//main线程会等等t3线程结束后，才执行后续代码
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println(Thread.currentThread().getName());

	}
	
	private static class Joinner implements Runnable {
		private Thread prev;
		public Joinner(Thread prev) {
			this.prev = prev;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				prev.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			
		}	
	}
	
	private static class Runner implements Runnable {
		
		@Override
		public void run() {
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

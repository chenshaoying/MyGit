package com.blackcat.frame.core.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class CallableAndFutureTest {
	
	public static void main(String[] args) {
		Callable<String> c = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + "------");
				return "fuck";
			}
			
		};
		
		//先启动线程去执行
		FutureTask<String> f = new FutureTask<String>(c);
		new Thread(f,"FF").start();
		try {
			//主线程处理其他事务
			Thread.sleep(1000);
			System.out.println("SSSSSSSS");
			//获取子线程计算的值,如果子线程没计算完会等待
			System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();  
        Future<Integer> future = threadPool.submit(new Callable<Integer>() {  
            public Integer call() throws Exception {  
            	 Thread.sleep(5000);
                return new Random().nextInt(100);  
            }  
        });  
        try {  
        //    Thread.sleep(5000);// 可能做一些事情  
        	System.out.println("------");
            System.out.println(future.get());  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        } 
	}
	
	@Test
	public void test3() {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		List<Callable<String>> taskList = new ArrayList<Callable<String>>();
		for(int i=0; i<20; i++) {
			final int x = i;
			taskList.add(new Callable<String>() {  
	            public String call() throws Exception {  
	            	TimeUnit.SECONDS.sleep(new Random().nextInt(3));
	                return Thread.currentThread().getName() + "："  + x + ":" + (new Random().nextInt(100));  
	            }  
	        });
		}
        
        try {
			List<Future<String>> futureList = threadPool.invokeAll(taskList);
			for(Future<String> f:futureList) {
				System.out.println(f.get());
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	@Test
	public void test4() throws InterruptedException {
		ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(1);  
		schedulePool.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				System.out.println(new Date().getSeconds());
				
			}
			
		}, 0, 2, TimeUnit.SECONDS);
		
		TimeUnit.SECONDS.sleep(10);
			
	}
	
	@Test
	public void test5() {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		System.out.println(Thread.currentThread().getName());
		//threadPool.shutdown();
		try {
			threadPool.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

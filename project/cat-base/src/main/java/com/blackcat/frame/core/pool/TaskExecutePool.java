package com.blackcat.frame.core.pool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class TaskExecutePool {
	private Queue<Task> queue;
	private List<Worker> workers;
	private int worker_num;
	private volatile boolean isOn;
	private TaskExecutePool() {
		
	}
	
	public static TaskExecutePool getInstance(int worker_num) {
		TaskExecutePool pool = new TaskExecutePool();
		pool.queue = new LinkedList<Task>();
		pool.workers = new LinkedList<Worker>();	
		pool.worker_num = worker_num;
		pool.isOn = false;
		return pool;
	}
	
	public void addTask(Task task) {
		synchronized(queue) {
			if(isOn) {
				this.queue.add(task);
				queue.notifyAll();				
			} else {
				throw new IllegalStateException("the pool is not started yet");		
			}
		}
	}
	
	public void addTaskList(List<Task> list) {
		synchronized(queue) {
			if(isOn) {
				this.queue.addAll(list);
				queue.notifyAll();				
			} else {
				throw new IllegalStateException("the pool is not started yet");		
			}
		}
	}
	
	/*private Task getTask() {
		
	}*/
	
	public void shutdown() {
		while(!queue.isEmpty()) {
			try {
				System.out.println("waiting for all task to be completed");
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.isOn = false;
		for(Worker worker:workers) {
			if(worker.isAlive()) {
				worker.interrupt();
			}
		}
		workers.clear();
	}
	
	public void startUp() {
		this.isOn = true;
		for(int i=0; i<worker_num; i++) {
			workers.add(new Worker("worker[" + i + "]"));
		}
		for(Worker worker:workers) {
			worker.start();
		}
	}
	
	public Task getTask() {
		synchronized(queue) {
			try {
				while(queue.isEmpty()) {
					queue.wait();							
				}
			} catch (InterruptedException e) {
			}
			queue.notifyAll();		
			return queue.poll();
		}
	}
	
	private class Worker extends Thread {
		Worker(String name) {
			super(name);
		}
		@Override
		public void run() {
			while(isOn) {
				Task task = getTask();					
				if(task != null) {
					task.run();						
				}
			}
			System.out.println(this.getName() + "closed");			
		}
	}

	
}



class Task implements Runnable {
	private String name;
	public Task(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!Thread.currentThread().isInterrupted()) {
			System.out.println(name + ":" + Thread.currentThread().getName());			
		}
	}
	
}
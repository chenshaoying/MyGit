package com.blackcat.frame.core.pool;

public class TaskExecutePoolTest {
	public static void main(String[] args) {
		TaskExecutePool pool = TaskExecutePool.getInstance(5);
		pool.startUp();			
		for(int i=0;i<100;i++) {
			pool.addTask(new Task("task" + i));			
		}
		pool.shutdown();
	}
}

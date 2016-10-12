package com.blackcat.frame.core.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import org.junit.Test;

public class ForkAndJoinTest2 {
	@Test
	public void tets1() throws InterruptedException, ExecutionException {
		 // 1. 创建任务
        SumTask sumTask = new SumTask(5);

        // 2. 创建线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 3. 提交任务到线程池
        forkJoinPool.submit(sumTask);
        
        System.out.println("结果：" + sumTask.get());
	}
	
	private class SumTask extends RecursiveTask<Integer> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int x;
		public SumTask(int x) {
			super();
			this.x = x;
		}
		@Override
		protected Integer compute() {
			int sum = 0;
			if(x == 1) {
				return 1;
			} else {
				System.out.println("递归：" + x);
				SumTask left = new SumTask(1);
				SumTask right = new SumTask(x-1);
				left.fork();
				right.fork();			
				return left.join() + right.join();
			}
		}
		
	}
}



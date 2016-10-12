package com.blackcat.frame.core.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import org.junit.Test;

public class ForkAndJoinTest {
	@Test
	public void tets1() throws InterruptedException, ExecutionException {
		 // 1. 创建任务
        SumTask sumTask = new SumTask(0,9);

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
		private int s;
		private int e;
		public SumTask(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		
		@Override
		protected Integer compute() {
			int sum = 0;
			if(e - s < 10) {
				for(int i = s; i <= e; i++ ) {
					sum += i;
				}
			} else {
				SumTask left = new SumTask(s, s+9);
				SumTask right = new SumTask(s+10, e);
				left.fork();
				right.fork();			
				return left.join() + right.join();
			}
			return sum;
		}
		
	}
}



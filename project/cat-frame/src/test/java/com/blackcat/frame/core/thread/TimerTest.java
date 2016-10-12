package com.blackcat.frame.core.thread;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class TimerTest {
	@Test
	public void test1() {
		Timer t = new Timer();
		MyTimerTask task = new MyTimerTask();
		t.schedule(task, 1000);
		while(true) {
			
		}
	}
}

class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("fuck");
		
	}
	
}


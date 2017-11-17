package com.thread;

import java.util.concurrent.TimeUnit;

public class StopThreadClass {

	public static void main(String[] args) throws Exception{
		Runner one = new Runner();
		Thread countThread = new Thread(one,"countThrad");
		countThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread.interrupted();
		Runner two = new Runner();
		countThread = new Thread(two,"two");
		countThread.start();
		TimeUnit.SECONDS.sleep(1);
		two.cancle();
	}
	private static class Runner implements Runnable{

		private int i;
		private volatile boolean on = true;
		@Override
		public void run() {
			while(on && !Thread.currentThread().isInterrupted()){
				i++;
			}
			System.out.println(Thread.currentThread().getName()+"-i: "+i);
		}
		public void cancle(){
			on = false;
		}
		
	}

}

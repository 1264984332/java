package com.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.management.RuntimeErrorException;

public class ThreadPoolClass {

	public static void main(String[] args) {
		ExecutorService pool = getThreadPool();
		pool.submit(new ConcreateRunnable());
		pool.submit(new ConcreateRunnable());
		pool.shutdown();
	}
	private static ExecutorService getThreadPool(){
		return Executors.newCachedThreadPool(new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				return newThread(r);
			}
		});
	}
	private static class ConcreateRunnable implements Runnable{
		@Override
		public void run() {
			for(int i = 1;i<=10;i++){
				try{
					Thread.sleep(10);
				}catch (InterruptedException  e) {
					throw new RuntimeException(e);
				}
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
			
		}
	}
}

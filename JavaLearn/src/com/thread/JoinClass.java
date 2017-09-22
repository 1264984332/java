package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class JoinClass {

	public static void main(String[] args) {
		FutureTask<Integer> future1 = new FutureTask<>(new JoinLearn(1));
		FutureTask<Integer> future2 = new FutureTask<>(new JoinLearn(1));
		FutureTask<Integer> future3 = new FutureTask<>(new JoinLearn(1));
		Thread thread1 = new Thread(future1,"future1");
		Thread thread2 = new Thread(future2,"future2");
		Thread thread3 = new Thread(future3,"future3");
		thread1.start();
		try {
			thread1.join(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		try {
			thread2.sleep(5000);
			thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		thread3.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
		}
		System.out.println("All threads are dead, exiting main thread");
	}
	private static class JoinLearn implements Callable<Integer>{
		int c;
		JoinLearn(int c){
			this.c = c;
		}
		@Override
		public Integer call() throws Exception {
			System.out.println("Thread started:::"+Thread.currentThread().getName());
	        try {
	            Thread.sleep(4000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Thread ended:::"+Thread.currentThread().getName());
			return c;
		}
		
	}
}

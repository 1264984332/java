package com.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaemonClass {

	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonThread(),"daemonThread");
		thread.setDaemon(true);
		thread.start();
		System.out.println(1);
	}

	static class DaemonThread implements Runnable{

		@Override
		public void run() {
			System.out.println(2);
			System.out.println("Thread Name："+Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
			try{
				long start = new Date().getTime();
				System.out.println("Thread Name："+Thread.currentThread().getName()+" ID:"+Thread.currentThread().getId());
				TimeUnit.SECONDS.sleep(3);
				System.out.println(Thread.currentThread().getName()+"noticefy!"+(new Date().getTime()-start));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Daemon thread run over!");
			}
		}
		
	}
}

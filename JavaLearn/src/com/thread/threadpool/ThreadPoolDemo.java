package com.thread.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		ThreadPoolExecutor pool = (ThreadPoolExecutor) MyThreadPool.newFixedThreadPool(5);
		for (int i = 0; i < 15; i++) {
			Mytask mytask = new Mytask(i+1);
			pool.execute(mytask);
			/*pool.submit(mytask);*/
			System.out.println("线程池的数目："+pool.getPoolSize()+"，队列中执行的任务数目："+pool.getQueue().size()+"，已执行完的任务数目："+pool.getCompletedTaskCount());
		}
		pool.shutdown();
	}

}

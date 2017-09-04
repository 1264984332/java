package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 用完一个线程池后, 应该调用该线程池的shutdown()方法,该方法将启动线程池关闭序列,不再接收新任务,但会将以前所有已提交的任务尽快执行完成.所有任务都执行完,池中所有线程都会死亡.
 * @author zlq
 *
 */
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

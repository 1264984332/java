package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 用完一个线程池后, 应该调用该线程池的shutdown()方法,该方法将启动线程池关闭序列,不再接收新任务,但会将以前所有已提交的任务尽快执行完成.所有任务都执行完,池中所有线程都会死亡.
 * @author zlq
 *
 */
public class ThreadPoolClass2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = getThreadPool();
		Future<Integer> task1 = pool.submit(new callable());
		Future<Integer> task2 =pool.submit(new callable());
		System.out.println(task1.isDone());
        System.out.println(task2.isDone());

        pool.shutdown();

        System.out.println("task1 " + task1.get());
        System.out.println("task2 " + task2.get());
	}

	private static ExecutorService getThreadPool() {
		return new ThreadPoolExecutor(5, 10, 20L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
	}

	private static class callable implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			int sum = 0;
			for (int i = 0; i < 10; ++i) {
				Thread.sleep(10);
				sum += i;
			}

			return sum;
		}
	}

}

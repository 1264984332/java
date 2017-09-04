package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Callable创建并启动线程的步骤如下: 1.实现Callable接口并重写call()方法; 2.使用FutureTask类包装Callable对象;
 * 3.将FutureTask实例提交给Thread并启动新线程; 4.使用FutureTask的get()获取子线程执行结束后的返回值.
 *
 * 由于实现Runnable和Callable的方式可以让多个线程共享同一个target,因此适用于多个线程处理同一份资源的情况,从而将CPU/代码/数据分开.
 * 
 * @author zlq
 *
 */
public class CallableClass {

	public static void main(String[] args) throws Exception {

		RunnableFuture<Integer> future = new FutureTask<>(new callableTest());
		new Thread(future).start();
		RunnableFuture<Integer> future1 = new FutureTask<>(new callableTest1());
		new Thread(future1).start();
		while (true) {
			System.out.println("主线程在干其他事情......");
			if (future.isDone()) {
				System.out.println("子线程返回值: " + future.get() + "  " + future1.get());
				break;
			}
			Thread.sleep(5);
		}
	}

	private static class callableTest implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int total = 0;
			for (int i = 1; i <= 10; i++)
				total += i;
			return total;
		}
	}

	private static class callableTest1 implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int total = 0;
			for (int i = 1; i <= 10; i++)
				total += i;
			return total;
		}
	}
}

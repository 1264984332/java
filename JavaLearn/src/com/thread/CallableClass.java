package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Callable�����������̵߳Ĳ�������: 1.ʵ��Callable�ӿڲ���дcall()����; 2.ʹ��FutureTask���װCallable����;
 * 3.��FutureTaskʵ���ύ��Thread���������߳�; 4.ʹ��FutureTask��get()��ȡ���߳�ִ�н�����ķ���ֵ.
 *
 * ����ʵ��Runnable��Callable�ķ�ʽ�����ö���̹߳���ͬһ��target,��������ڶ���̴߳���ͬһ����Դ�����,�Ӷ���CPU/����/���ݷֿ�.
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
			System.out.println("���߳��ڸ���������...");
			if (future.isDone()) {
				System.out.println("���̷߳���ֵ: " + future.get() + "  " + future1.get());
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

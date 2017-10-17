package com.thread;
/**
 * 实现Runnable接口,重写run()方法(同样代表线程执行体),并将该类实例作为Thread的target提交给线程执行.
 * 运行上例可以看到i值重复的现象,这是因为有多个线程都在修改同一个i值, 对于并发修改共享资源的情况,需要添加同步机制保护,详见下面.
 * 
 * Runnable对象仅作为Thread对象的target,其包含的run()方法仅作为线程执行体.实际的线程对象依然是Thread实例, 只是该Thread线程执行的是target的run()方法.
 * @author zlq
 *
 */
public class RunnableClass {

	public static void main(String[] args) {
		Runnable runnable = new runnableTest();
		new Thread(runnable,"first").start();
		new Thread(runnable).start();
		for (int i = 0; i < 10; ++i) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
	}
	private static class runnableTest implements Runnable{
		private int i = 0;
		public void run() {
			for(;i<10;i++){
				System.out.println(Thread.currentThread().getName()+": "+i);
			}
		}
	}
}

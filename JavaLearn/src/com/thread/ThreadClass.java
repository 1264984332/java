package com.thread;


/**
 * 
 * 继承Thread类,并重写run()方法(代表线程执行体),然后调用start()方法来启动线程.
 * 继承Thread类来创建线程类时,多个线程之间无法共享线程类的实例变量.
 * @author zlq
 *
 */
public class ThreadClass {

	public static void main(String[] args) {
		new threadTest().start();
		new threadTest("second").start();
		for(int  i= 0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+":  "+i);
		}
	}

	private static class threadTest extends Thread {
		public threadTest() {
		}
		public threadTest(String name){
			super(name);
		}
		@Override
		public void run() {
			for (int i = 0; i < 10; i++)
				System.out.println(getName() + ": " + i);
		}
	}
}

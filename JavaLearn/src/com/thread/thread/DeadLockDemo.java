package com.thread.thread;

/**
 * 模拟死锁
 * 避免的方式：1、避免一个线程获得多个锁
 * 			2、避免一个线程在锁内同时占用多个资源，尽量保证一个锁占用一个资源
 * 			3、尽量使用定时锁替换内部锁机制
 * 			4、对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败
 * @author zlq
 *
 */
public class DeadLockDemo {

	private static String A = "A";
	private static String B = "B";
	public static void main(String[] args) {
		new DeadLockDemo().deadLock();
	}
	private void deadLock(){
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("T1");
				synchronized(A){
					System.out.println("T1-A");
					try {
						Thread.currentThread().sleep(2000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized(B){
						System.out.println("1");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("T2");
				synchronized(B){
					System.out.println("T2-B");
					synchronized(A){
						System.out.println("2");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}

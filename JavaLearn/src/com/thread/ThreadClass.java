package com.thread;


/**
 * 
 * �̳�Thread��,����дrun()����(�����߳�ִ����),Ȼ�����start()�����������߳�.
 * �̳�Thread���������߳���ʱ,����߳�֮���޷������߳����ʵ������.
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

package com.thread;
/**
 * ʵ��Runnable�ӿ�,��дrun()����(ͬ�������߳�ִ����),��������ʵ����ΪThread��target�ύ���߳�ִ��.
 * �����������Կ���iֵ�ظ�������,������Ϊ�ж���̶߳����޸�ͬһ��iֵ, ���ڲ����޸Ĺ�����Դ�����,��Ҫ���ͬ�����Ʊ���,�������.
 * 
 * Runnable�������ΪThread�����target,�������run()��������Ϊ�߳�ִ����.ʵ�ʵ��̶߳�����Ȼ��Threadʵ��, ֻ�Ǹ�Thread�߳�ִ�е���target��run()����.
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

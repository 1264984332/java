package com.thread.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadlLocalClass {

	
	public static void main(String[] args) {
		ThreadlLocalClass localClass = new ThreadlLocalClass();
		for(int i = 0;i<3;i++){
			new TestClient(localClass).start(); 
		}
	}
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){;
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};
	
	public int getNextNum(){
		threadLocal.set(threadLocal.get()+1);
		return threadLocal.get();
	}
	
	public int get(){
		return threadLocal.get();
	}
	
	public void set(Integer integer){
		threadLocal.set(integer);
	}
	
	private static class TestClient extends Thread{
		private ThreadlLocalClass l;
		public TestClient(ThreadlLocalClass l){
			this.l = l;
		}
		public void run(){
			for(int i =0;i<5;i++)
				System.out.println("当前线程："+Thread.currentThread().getName()+"--》ThreadLocal副本的数字"+l.getNextNum());
		}
	}
}

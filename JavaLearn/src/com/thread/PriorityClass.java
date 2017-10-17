package com.thread;

public class PriorityClass {

	public static final int MIN_PRIORITY = 1;
	public static final int MID_PRIORITY = 5;
	public static final int MAX_PRIORITY = 10;
	
	public static void main(String[] args) {
		Thread min = new Thread(new PriorityRunnable(),"min");
		Thread mid = new Thread(new PriorityRunnable(),"mid");
		Thread max = new Thread(new PriorityRunnable(),"max");
		min.setPriority(MIN_PRIORITY);
		mid.setPriority(MID_PRIORITY);
		max.setPriority(MAX_PRIORITY);
		Thread [] aThreads = {min,mid,max};
		start(aThreads);
	}
	
	private static void start(Thread... threads){
		for(Thread thread:threads){
			thread.start();
		}
	}
	private static class PriorityRunnable implements Runnable{
		@Override
		public void  run(){
			for(int i = 0;i<10;i++){
				System.out.println(Thread.currentThread().getName()+" : "+(i+1));
			}
		}
	}
}

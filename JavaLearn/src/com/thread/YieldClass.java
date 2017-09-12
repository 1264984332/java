package com.thread;

public class YieldClass {

	public static void main(String[] args) {
		yieldThread yThread = new yieldThread();
		yThread.start();
		System.out.println("yield start");
		yThread.yield();
		System.out.println("yield end");
	}
	private static class  yieldThread extends Thread{
		@Override
		public void run() {
			System.out.println("yield...");
		}
	}
}

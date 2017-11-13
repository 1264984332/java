package com.thread;
/**
 * 使当前线程从执行状态（运行状态）变为可执行态（就绪状态）
 * @author zlq
 *
 */
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

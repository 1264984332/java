package com.thread.threadpool;

public class Mytask implements Runnable {

	private int taskNum;

	public Mytask(int taskNum) {
		this.taskNum = taskNum;
	}

	@Override
	public void run() {
		System.out.println( "taskNum: " + taskNum + "开始线程工作。。");
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskNum + "执行完毕");
	}

	public int getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(int taskNum) {
		this.taskNum = taskNum;
	}

}

package com.thread;

public class Account {

	private double balance;
	private boolean hasBalance = false;

	public double getBalance(double amount) {
		return balance;
	}

	public synchronized void getMoney(double money) throws InterruptedException {
		if (!hasBalance) {// 没有存款，则等待
			wait();
		}
		System.out.printf("%s执行取钱操作", Thread.currentThread().getName());
		balance -= money;
		System.out.printf(", 当前余额%f%n", balance);
		hasBalance = false;

		// 唤醒其他线程
		notifyAll();
	}

	public synchronized void putMoney(double money) throws InterruptedException {
		if (hasBalance) {
			wait();
		}
		System.out.printf("%s执行存钱操作", Thread.currentThread().getName());
		balance += money;
		System.out.printf(", 当前余额%f%n", balance);
		hasBalance = true;

		// 唤醒其他线程
		notifyAll();
	}
}

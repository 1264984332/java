package com.thread;

public class Account {

	private double balance;
	private boolean hasBalance = false;

	public double getBalance(double amount) {
		return balance;
	}

	public synchronized void getMoney(double money) throws InterruptedException {
		if (!hasBalance) {// û�д���ȴ�
			wait();
		}
		System.out.printf("%sִ��ȡǮ����", Thread.currentThread().getName());
		balance -= money;
		System.out.printf(", ��ǰ���%f%n", balance);
		hasBalance = false;

		// ���������߳�
		notifyAll();
	}

	public synchronized void putMoney(double money) throws InterruptedException {
		if (hasBalance) {
			wait();
		}
		System.out.printf("%sִ�д�Ǯ����", Thread.currentThread().getName());
		balance += money;
		System.out.printf(", ��ǰ���%f%n", balance);
		hasBalance = true;

		// ���������߳�
		notifyAll();
	}
}

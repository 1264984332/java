package com.thread.entity;

public class Account {

	private double banlance;

	public Account() {
	}

	public Account(double account) {
		this.banlance = account;
	}

	public double getBanlance() {
		return banlance;
	}

	public void setBanlance(double banlance) {
		this.banlance = banlance;
	}

	public void reduceBalance(double count) {
		this.banlance -= count;
	}

	public synchronized boolean draw(double money) {
		if (getBanlance() > money) {
			System.out.println(Thread.currentThread().getName() + "取钱" + money + "成功");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			banlance -= money;
			System.out.println("\t" + Thread.currentThread().getName() + "成功后的余额: " + getBanlance());
			return true;
		} else {
			System.out.println(Thread.currentThread().getName() + "取钱失败");
			System.out.println("\t" + Thread.currentThread().getName() + "失败后的余额: " + getBanlance());
			return false;
		}
	}
}

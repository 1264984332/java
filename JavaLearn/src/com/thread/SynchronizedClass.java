package com.thread;

import com.thread.entity.Account;

public class SynchronizedClass {

	public static void main(String[] args) {
		Runnable r = new SynchronizedRunnable(new Account(800), 300);

		Thread a = new Thread(r, "甲");
		Thread b = new Thread(r, "乙");
		a.setPriority(9);
		b.setPriority(3);
		b.start();
		a.start();
	}

	private static class SynchronizedRunnable implements Runnable {
		private Account account;
		private double accountMoney;

		public SynchronizedRunnable(Account account, double money) {
			this.account = account;
			this.accountMoney = money;
		}

		@Override
		public void run() {
			/*while (true) {
				synchronized(account){
					if (account.getBanlance() > accountMoney) {
						System.out.println(Thread.currentThread().getName() + "取钱" + accountMoney + "成功");
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
						account.reduceBalance(accountMoney);
						System.out.println("\t" + Thread.currentThread().getName() + "成功后的余额: " + account.getBanlance());
					} else {
						System.out.println(Thread.currentThread().getName() + "取钱失败");
						System.out.println("\t" + Thread.currentThread().getName() + "失败后的余额: " + account.getBanlance());
						break;
					}
				}
				
			}*/
			while (account.draw(accountMoney)) {
	        }
		}
	}
}

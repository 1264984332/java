package com.thread;

public class WaitAndNotify {

	public static void main(String[] args) {
		Account account = new Account();
		new Thread(new WaitAndNotifyRunable1(account, 100), "- »°«Æ’ﬂ").start();
		new Thread(new WaitAndNotifyRunable2(account, 100), "+ ¥Ê«Æ’ﬂ").start();
	}

	private static class WaitAndNotifyRunable1 implements Runnable {
		private Account account;
		private double amount;

		public WaitAndNotifyRunable1(Account account, double amount) {
			this.account = account;
			this.amount = amount;
		}

		@Override
		public void run() {
			while (true) {
				try {
					account.getMoney(amount);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	private static class WaitAndNotifyRunable2 implements Runnable {
		private Account account;
		private double amount;

		public WaitAndNotifyRunable2(Account account, double amount) {
			this.account = account;
			this.amount = amount;
		}

		@Override
		public void run() {
			while (true) {
				try {
					account.putMoney(amount);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}

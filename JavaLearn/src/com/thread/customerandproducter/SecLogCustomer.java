package com.thread.customerandproducter;

public class SecLogCustomer implements Runnable {

	@Override
	public void run() {
		while (true) {
			SecLogStorage.getInstance().consume();
		}
	}
}

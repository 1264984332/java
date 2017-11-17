package com.thread.customerandproducter;

public class SecLogProduceThread implements Runnable {

	SecLogEntity entity = null;
	
	public SecLogProduceThread(SecLogEntity entity) {
		this.entity = entity;
	}
	
	@Override
	public void run() {
		SecLogStorage.getInstance().produce(entity);
	}

}

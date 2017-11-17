package com.thread.customerandproducter;

import java.util.concurrent.LinkedBlockingQueue;

import com.alibaba.fastjson.JSONObject;

public class SecLogStorage {

	private static SecLogStorage instance =null;
	private int MAX_SIZE = 100;
	private LinkedBlockingQueue<SecLogEntity> blockingQueue = new LinkedBlockingQueue<SecLogEntity>(MAX_SIZE);
	
    private SecLogStorage() {
    }
 
    public static SecLogStorage getInstance() {
    	if(instance==null){
    		synchronized (SecLogStorage.class) {
				if(instance == null)
					instance = new SecLogStorage();
			}
    	}
        return instance;
    }
    
    public void produce(SecLogEntity entity){
    	if (blockingQueue.size() == MAX_SIZE) {
            System.out.println("seclog库存量为" + MAX_SIZE + ",不能再继续生产！");
        }
    	try {
			blockingQueue.add(entity);
			 System.out.println("生产SecLog："+ JSONObject.toJSONString(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public SecLogEntity consume(){
        SecLogEntity entity = null;
        if(blockingQueue.isEmpty()){
            System.out.println("seclog库存量为0，不能再继续消费！");
        }
        try {
            entity = blockingQueue.take();
            System.out.println("消费SecLog："+JSONObject.toJSONString(entity));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return entity;
    }
}

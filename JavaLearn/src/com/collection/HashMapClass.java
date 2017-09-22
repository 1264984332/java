package com.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HashMapClass {

	public static void main(String[] args) {
		final Lock mutex = new ReentrantLock();
		mutex.newCondition();
		Map<String, Object> map = new HashMap<>();
		for(int i = 1;i<=10;i++){
			map.put(i+"", i);
		}
		System.out.println("使用Map.Entry输出map...");
		for(Map.Entry<String, Object> entry:map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}

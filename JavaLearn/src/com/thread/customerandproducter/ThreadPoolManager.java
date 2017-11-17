package com.thread.customerandproducter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池管理类
 * 
 * @author Administrator
 *
 */
public class ThreadPoolManager {
	private static ThreadPoolManager instance = null;

	private ExecutorService secLogThreadPool;
	private ExecutorService sysLogThreadPool;

	private ThreadPoolManager() {
		secLogThreadPool = new ThreadPoolExecutor(1, 3, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000),new ThreadPoolExecutor.CallerRunsPolicy());
		sysLogThreadPool = Executors.newFixedThreadPool(3);
	}

	/**
	 * 单例模式返回线程池管理对象
	 * 
	 * @return
	 */
	public static ThreadPoolManager getThreadPoolManager() {
		if (instance == null) {
			synchronized (ThreadPoolManager.class) {
				if (instance == null)
					instance = new ThreadPoolManager();
			}
		}
		return instance;
	}

	public ExecutorService getSecLogThreadPool() {
		return secLogThreadPool;
	}

	public void setSecLogThreadPool(ExecutorService secLogThreadPool) {
		this.secLogThreadPool = secLogThreadPool;
	}

	public ExecutorService getSysLogThreadPool() {
		return sysLogThreadPool;
	}

	public void setSysLogThreadPool(ExecutorService sysLogThreadPool) {
		this.sysLogThreadPool = sysLogThreadPool;
	}

}

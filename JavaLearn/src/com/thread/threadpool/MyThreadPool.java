package com.thread.threadpool;

import java.util.concurrent.*;

/**
 * 获得三种线程池
 *
 * @author Administrator
 *
 */
public class MyThreadPool {

	private static ExecutorService fixedThreadPool = null;
	private static ExecutorService singleThreadPool = null;
	private static ExecutorService cacheThreadPool = null;

	public static ExecutorService newFixedThreadPool(int corePoolSize) {
		if (null == fixedThreadPool) {
			synchronized (MyThreadPool.class) {
				if (null == fixedThreadPool) {
					fixedThreadPool = new ThreadPoolExecutor(corePoolSize, corePoolSize, 0L, TimeUnit.MILLISECONDS,
							new LinkedBlockingQueue<Runnable>());
				}

			}
		}
		return fixedThreadPool;
	}

	public static ExecutorService newSingleThreadPool() {
		if (singleThreadPool == null) {
			synchronized (MyThreadPool.class) {
				if (singleThreadPool == null)
					singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
							new LinkedBlockingQueue<Runnable>());
			}
		}
		return singleThreadPool;
	}

	public static ExecutorService newCacheThreadPool() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		if (cacheThreadPool == null) {
			synchronized (MyThreadPool.class) {
				if (cacheThreadPool == null)
					cacheThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 6L, TimeUnit.MILLISECONDS,
							new SynchronousQueue<Runnable>());
			}
		}
		return cacheThreadPool;
	}
}

package com.thread.consumerproducer;

import java.util.concurrent.*;

/**
 * Created by liyongguan on 2018/1/5.
 */
public class ThreadPoolClass {
    ExecutorService threadPool ;
    public ExecutorService getThreadPool(){
        if(null ==threadPool){
            synchronized (ThreadPoolClass.class){
                if(null == threadPool){
                    threadPool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                            new LinkedBlockingQueue<Runnable>());
                }
            }
        }
        return threadPool;
    }

}

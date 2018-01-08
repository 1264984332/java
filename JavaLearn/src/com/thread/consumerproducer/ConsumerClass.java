package com.thread.consumerproducer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by liyongguan on 2018/1/5.
 * 消费者线程
 */
public class ConsumerClass implements Runnable {
    private BlockingQueue<String> queue;
    public ConsumerClass(BlockingQueue queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            String temp = queue.take();
            System.out.println("消费者线程"+Thread.currentThread().getName()+"消费信息： "+temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

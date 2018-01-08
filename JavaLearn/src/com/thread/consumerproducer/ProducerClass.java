package com.thread.consumerproducer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by liyongguan on 2018/1/5.
 * 生产者
 *
 */
public class ProducerClass implements Runnable {

    BlockingQueue<String> queue;
    public ProducerClass(BlockingQueue queue){
        this.queue = queue;
    }
    public  void run(){
        try {
            String tem = "生产者"+Thread.currentThread().getName()+"生产内容";
            System.out.println(tem);
            queue.put(tem);
        }catch (InterruptedException e){

        }
    }

}

package com.thread.consumerproducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by liyongguan on 2018/1/5.
 */
public class TestClass {
    public static void main(String[] args){
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

        for(int i = 0;i<10;i++){
           new Thread(new ConsumerClass(blockingQueue)).start();
            new Thread(new ProducerClass(blockingQueue)).start();
        }
    }
}

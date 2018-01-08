package com.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liyongguan on 2018/1/3.
 */
public class CountDownLatchClass {


    public static void main(String[] args) throws  Exception{
       CountDownLatch cdl = new CountDownLatch(5);
       for(int i = 0;i<5;i++){
            new Thread(new ReadNum(i,cdl)).start();
           // System.out.println(i);
       }
        cdl.await();
        System.out.println("线程执行结束。。。。");
    }

    public  static class ReadNum implements Runnable{

        private int id;
        private CountDownLatch cdl;
        public  ReadNum(int id,CountDownLatch cdl){
            this.id = id;
            this.cdl = cdl;
        }
        @Override
        public void run() {
            synchronized (this){
                System.out.println("id: "+id);
                cdl.countDown();
                System.out.println("线程组任务"+id+"结束，其他任务继续");
            }
        }
    }
}

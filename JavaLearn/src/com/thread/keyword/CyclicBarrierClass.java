package com.thread.keyword;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by liyongguan on 2018/1/12.
 */
public class CyclicBarrierClass {

    public static void main(String[] args) throws Exception{
        int N = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        for(int i = 0;i<N;i++){
            new Thread(new Writer(cyclicBarrier)).start();;
        }
    }

    static class Writer implements Runnable{

        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"开始写入数据。。。");
            try{
                Thread.sleep(1000);
                System.out.println("写入完成"+Thread.currentThread().getName());
                cyclicBarrier.wait();
            }catch (InterruptedException e) {
            }

        }
    }
}

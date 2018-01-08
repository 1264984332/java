package com.thread.sortrunthread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liyongguan on 2018/1/4.
 */
public class CountDownLatchTest {
    static CountDownLatch cdl1 = new CountDownLatch(1);
    static CountDownLatch cdl2 = new CountDownLatch(1);
    public static void main(String[] args){

        Thread thread1 = new JoinTest.Thread1();
        Thread thread2 = new JoinTest.Thread2();
        Thread thread3 = new JoinTest.Thread3();
        thread1.start();
        thread2.start();
        thread3.start();
    }


    static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println("thread1");
        }
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                cdl1.wait();
                System.out.println("thread2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

           cdl1.countDown();
        }
    }
    static class Thread3 extends Thread{
        @Override
        public void run() {
            try{
                cdl2.wait();
                System.out.println("thread3");
            }catch (InterruptedException e){

            }
            cdl2.countDown();
        }
    }
}

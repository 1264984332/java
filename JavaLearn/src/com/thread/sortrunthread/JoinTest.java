package com.thread.sortrunthread;

/**
 * Created by liyongguan on 2018/1/4.
 */
public class JoinTest {

    public static void main(String[] args)throws  InterruptedException{
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        Thread thread3 = new Thread3();
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        System.out.println("ok");
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
            System.out.println("thread2");
        }
    }
    static class Thread3 extends Thread{
        @Override
        public void run() {
            System.out.println("thread3");
        }
    }
}

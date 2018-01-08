package com.thread.sortrunthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyongguan on 2018/1/4.
 */
public class ThreadPoolTest {

    public static void main(String[] args){
        ExecutorService s = new ThreadPoolExecutor(1,1,0,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        s.execute(new Thread1());
        s.execute(new Thread2());
        s.execute(new Thread3());
        s.shutdown();
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

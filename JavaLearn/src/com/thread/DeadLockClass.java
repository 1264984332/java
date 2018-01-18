package com.thread;

/**
 * Created by liyongguan on 2018/1/12.
 */
public class DeadLockClass {
    static Object o1 = new Object(),o2 = new Object();
    public static void main(String[] args){
        Thread t1 = new Thread(new RunThreadClass(1),"AAA");
        Thread t2 = new Thread(new RunThreadClass(0),"BBB");
        t1.start();
        t2.start();
    }


    static class RunThreadClass  implements Runnable{
        int flag = 0;
        public RunThreadClass(int flag){
            this.flag = flag;
        }
        public void run(){
            System.out.println("flag=" + flag);
            if(flag ==1){
                try{
                    synchronized(o1){
                        System.out.println(Thread.currentThread().getName()+"获得对象1");
                        Thread.sleep(5000);
                        synchronized(o2){
                            System.out.println(Thread.currentThread().getName()+"获得对象1");
                        }
                    }

                }catch (InterruptedException e){

                }
            }
            if(flag ==0){
                try{
                    synchronized(o2){
                        System.out.println(Thread.currentThread().getName()+"获得对象2");
                        Thread.sleep(5000);
                        synchronized(o1){
                            System.out.println(Thread.currentThread().getName()+"获得对象1");
                        }
                    }

                }catch (InterruptedException e){

                }
            }

        }
    }

    /*static class RunThreadClass2  extends Thread{
        public void run(){
            try{
                synchronized(o2){
                    System.out.println(Thread.currentThread().getId()+"获得对象1");
                }
                Thread.sleep(500);
                synchronized(o2){
                    System.out.println(Thread.currentThread().getId()+"获得对象1");
                }
            }catch (InterruptedException e){

            }

        }
    }*/
}

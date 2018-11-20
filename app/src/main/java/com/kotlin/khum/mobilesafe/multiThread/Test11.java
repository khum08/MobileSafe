package com.kotlin.khum.mobilesafe.multiThread;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test11 {
    public static void main(String[] arg){
        ThreadB t1 = new ThreadB("t1");
        synchronized(t1){
            System.out.println(Thread.currentThread().getName()+ " start t1");
            t1.start();

            System.out.println(Thread.currentThread().getName()+ " call wait");
            try {
                t1.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" continue");
        }
    }
}

class ThreadB extends Thread{

    public ThreadB(String threadName){
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" running");
        while(true);
    }
}

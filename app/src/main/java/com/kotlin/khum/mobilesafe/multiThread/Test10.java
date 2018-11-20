package com.kotlin.khum.mobilesafe.multiThread;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test10 {
    public static void main(String[] arg){
        ThreadA t1 = new ThreadA("t1");
        synchronized (t1){
            System.out.println(Thread.currentThread().getName()+" start t1");
            t1.start();
            try {
                System.out.println(Thread.currentThread().getName()+" wait()");
                //引起 当前线程 等待
                t1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" continue");
        }
    }


}

class ThreadA extends Thread{
    public ThreadA(String name){
        super(name);
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ThreadA.currentThread().getName()+" call notify()");
            notify();
        }
    }
}

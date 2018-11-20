package com.kotlin.khum.mobilesafe.multiThread;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test12 {

    public static void main(String[] arg){
        Object obj = new Object();
        ThreadC t1 = new ThreadC("t1", obj);
        ThreadC t2 = new ThreadC("t2", obj);
        ThreadC t3 = new ThreadC("t3", obj);
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(Thread.currentThread().getName()+" sleep(3000)");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+" notifyAll");
            obj.notifyAll();
        }

    }
}

class ThreadC extends Thread{

    Object obj;

    public ThreadC(String name, Object obj){
        super(name);
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" wait");
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " continue");
        }
    }
}
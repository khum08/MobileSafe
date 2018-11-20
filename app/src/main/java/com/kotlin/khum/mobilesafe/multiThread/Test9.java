package com.kotlin.khum.mobilesafe.multiThread;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test9 {

    public static void main(String[] arg){
        test2();
    }

    public static void test1(){
        //同一个runnable对象锁
        MyRunnable9 runnable = new MyRunnable9();
        Thread thread1 = new Thread(runnable, "t1");
        Thread thread2 = new Thread(runnable, "t2");
        thread1.start();
        thread2.start();
    }

    public static void test2(){
        //不同runnable对象锁
        Thread t1 = new Thread(new MyRunnable9(), "t1");
        Thread t2 = new Thread(new MyRunnable9(), "t2");
        t1.start();
        t2.start();
    }


}
class MyRunnable9 implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" loop "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

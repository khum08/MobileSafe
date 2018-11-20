package com.kotlin.khum.mobilesafe.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 *     author : khum
 *     desc   : 一个线程去等待多个线程完成后继续 CountDownLatch
 * </pre>
 */
public class Test6 {

    public static void main(String[] arg){
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        Thread6 t1 = new Thread6("A", countDownLatch);
        Thread6 t2 = new Thread6("B", countDownLatch);
        Thread6 t3 = new Thread6("C", countDownLatch);
        Thread6 t4 = new Thread6("D", countDownLatch);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

class Thread6 extends Thread{

    private CountDownLatch countDownLatch;

    public Thread6(String name, CountDownLatch countDownLatch) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (this.getName().equals("A")){
            try {
                countDownLatch.await();//阻塞当前线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 200; i++){
            System.out.println(this.getName()+":"+i);
        }
        if (!this.getName().equals("A")){
            countDownLatch.countDown();//唤醒当前线程
        }
    }
}
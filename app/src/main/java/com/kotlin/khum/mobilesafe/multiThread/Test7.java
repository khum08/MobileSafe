package com.kotlin.khum.mobilesafe.multiThread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <pre>
 *     author : khum
 *     desc   : 多个线程相互等待 同时起跑
 *     CyclicBarrier可以重用，而countDownLatch不能重用？
 * </pre>
 */
public class Test7 {

    public static void main(String[] arg){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        
        Thread7 t1 = new Thread7("A", cyclicBarrier);
        Thread7 t2 = new Thread7("B", cyclicBarrier);
        Thread7 t3 = new Thread7("C", cyclicBarrier);
        Thread7 t4 = new Thread7("D", cyclicBarrier);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Thread7 extends Thread{

    private CyclicBarrier cyclicBarrier;
    public Thread7(String name, CyclicBarrier cyclicBarrier) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        long prepareTime = new Random().nextInt(10000)+100;
        try {
            System.out.println("prepared time is "+ prepareTime);
            sleep(prepareTime);
            System.out.println("i am waiting");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("i am running");
    }
}

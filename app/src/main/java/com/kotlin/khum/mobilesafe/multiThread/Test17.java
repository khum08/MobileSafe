package com.kotlin.khum.mobilesafe.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 *     author : yuanzhenkun
 *     desc   :
 * </pre>
 */

public class Test17 {
    public static void main(String[] arg){
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(new FirstBatchWorker(countDownLatch));
            thread.start();
        }
        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(new SecondBatchWorker(countDownLatch));
            thread.start();
        }


    }
}
class FirstBatchWorker implements Runnable{

    private final CountDownLatch latch;

    public FirstBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("First batch executed.");
        latch.countDown();
    }
}
class SecondBatchWorker implements Runnable{

    private final CountDownLatch latch;

    public SecondBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Second batch executed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

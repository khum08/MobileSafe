package com.kotlin.khum.mobilesafe.multiThread;

import java.util.concurrent.Semaphore;

/**
 * <pre>
 *     author : yuanzhenkun
 *     desc   : semaphore 信号量
 * </pre>
 */

public class Test16 {

    public static void main(String[] arg){
        System.out.println("Action go...");
        Semaphore semaphore = new Semaphore(5);
        for(int i = 0; i < 20; i++){
            Thread thread = new Thread(new SemaphoreWorker(semaphore));
            thread.start();
        }
    }
}

class SemaphoreWorker implements Runnable{
    Semaphore semaphore;
    public SemaphoreWorker(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is waiting for a permit");
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" acquired a permit；semaphore is "+ semaphore.availablePermits());
            System.out.println(Thread.currentThread().getName()+" executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+" released a permit；semaphore is "+ semaphore.availablePermits());
            semaphore.release();
        }
    }
}

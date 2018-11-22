package com.kotlin.khum.mobilesafe.multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test18 {

    ReentrantLock mLock = new ReentrantLock(true);
    Condition mCondition = mLock.newCondition();
    CountDownLatch mLatch = new CountDownLatch(1);
    int count;

    public static void main(String[] arg) {
        Test18 test = new Test18();
        test.decrement();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.increment();
    }

    public void increment(){
        new Thread(){
            @Override
            public void run() {
                System.out.println(mLock.isFair());
                mLock.lock();
                try{
                    mLatch.countDown();
                    count++;
                    System.out.println("i am increment");
                    //await会释放当前持有的锁
                    mCondition.await();
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("i am increment:"+ count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mLock.unlock();
                }
            }
        }.start();
    }

    public void decrement(){
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("i am waiting...");
                    mLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mLock.lock();
                try{
                    count--;
                    System.out.println("i am decrement:"+ count);
                    mCondition.signal();
                }finally {
                    mLock.unlock();
                }
            }
        }.start();
    }

}

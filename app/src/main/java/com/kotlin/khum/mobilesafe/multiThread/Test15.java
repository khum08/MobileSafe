package com.kotlin.khum.mobilesafe.multiThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 *     author : yuanzhenkun
 *     desc   :
 * </pre>
 */

public class Test15 {

    ReentrantLock mLock = new ReentrantLock();
    private int sharedState;

    public void nonSafeAction(){
        mLock.lock();
        try{
            while(sharedState<100000){
                int former = sharedState++;
                int latter = sharedState;
                if (former != latter-1){
                    System.out.println("Observed data race, former is "+former+", latter is "+latter);
                }
            }
        }finally {
            mLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test15 test = new Test15();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                test.nonSafeAction();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                test.nonSafeAction();
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}

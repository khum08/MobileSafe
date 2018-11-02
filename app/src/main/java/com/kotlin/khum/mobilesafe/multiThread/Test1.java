package com.kotlin.khum.mobilesafe.multiThread;

import java.util.Calendar;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test1 {

    public static void main(String[] arg) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println("this is main thread");

        defaultDeliveryTime();
    }

    private static void defaultDeliveryTime() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, 16);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        long boundary = instance.getTime().getTime();
        long current = System.currentTimeMillis();

        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DAY_OF_MONTH);

        if (current > boundary){
            System.out.println(year+"-"+(month+1)+"-"+(day+1));
        }else{
            System.out.println(year+"-"+(month+1)+"-"+day);
        }


    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i am second thread:" + Thread.currentThread().getName());
        }
    }



}

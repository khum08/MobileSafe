package com.kotlin.khum.mobilesafe.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test14 {

    public static void main(String[] arg){
        ThreadE t1 = new ThreadE("normal thread");
        DaemonThread t2 = new DaemonThread("daemon thread");
        t2.setDaemon(true);
        //放入线程池中后设置的线程名就没用了
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(t1);
        executorService.execute(t2);
        System.out.println(Thread.currentThread().getName()+" is over");
    }

}
//普通线程
class ThreadE extends Thread{

    public ThreadE(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName()+" is running: i="+i);
        }
    }

}
//守护线程
class DaemonThread extends Thread{

    public DaemonThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName()+" is running: i="+i);
        }
    }
}

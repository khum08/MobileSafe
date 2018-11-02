package com.kotlin.khum.mobilesafe.multiThread;

/**
 * <pre>
 *     author : khum
 *     desc   : 多个线程依次执行
 * </pre>
 */
public class Test4 {
    public static void main(String[] arg){
        Thread4 t1 = new Thread4(null);
        Thread4 t2 = new Thread4(t1);
        Thread4 t3 = new Thread4(t2);
        t1.start();
        t2.start();
        t3.start();
    }

}

class Thread4 extends Thread{

    Thread waitThread;

    public Thread4(Thread waitThread) {
        this.waitThread = waitThread;
    }

    @Override
    public void run() {
        for(int i = 1; i < 400; i++){
            if (waitThread !=null ) {
                try {
                    waitThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getName()+":"+i);
        }
    }
}


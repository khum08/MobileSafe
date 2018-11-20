package com.kotlin.khum.mobilesafe.multiThread;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test13 {

    public static void main(String[] arg){
        ThreadD t1 = new ThreadD("t1");
        ThreadD t2 = new ThreadD("t2");
        t1.start();
        t2.start();
    }
}

class ThreadD extends Thread{

    public ThreadD(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(),i);
            if (i%4==0){
                //让步，线程由运行状态进入就绪状态，不会释放Monitor锁
//                Thread.yield();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

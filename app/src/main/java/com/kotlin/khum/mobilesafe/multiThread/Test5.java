package com.kotlin.khum.mobilesafe.multiThread;

/**
 * <pre>
 *     author : khum
 *     desc   : 两个线程有序交叉执行
 * </pre>
 */
public class Test5 {

    public static void main(String[] arg){
        Object lock = new Object();
        Thread5 t1 = new Thread5("A",lock);
        Thread5 t2 = new Thread5("B",lock);
        t1.start();
        t2.start();
    }

}

class Thread5 extends Thread{

    private Object lock;

    public Thread5(String name, Object lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            for(int i = 1; i < 4; i++){
                System.out.println(this.getName()+":number is "+ i);
                if (i == 1 && this.getName().equals("A")){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i==2 && this.getName().equals("B")){
                    lock.notify();
                }
            }
        }
    }
}

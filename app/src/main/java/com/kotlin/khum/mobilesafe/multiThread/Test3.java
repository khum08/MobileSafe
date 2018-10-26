package com.kotlin.khum.mobilesafe.multiThread;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class Test3 {
    public static void main(String[] arg){
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }
}

class MyRunnable implements Runnable{

    boolean cancel = false;

    @Override
    public void run() {
        while(!cancel){
            cancel = true;
            for(int i = 0; i < 30; i++){
                System.out.println("number is"+i);
            }
        }
    }

    public void setCancel(boolean cancel){
        this.cancel = cancel;
    }


}

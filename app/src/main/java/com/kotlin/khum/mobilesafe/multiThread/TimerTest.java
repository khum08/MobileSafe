package com.kotlin.khum.mobilesafe.multiThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <pre>
 *     author : khum
 *     desc   : 计时器的使用
 * </pre>
 */
public class TimerTest {
    static int count = 0;
    public static void main(String[] arg){
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                count++;
                System.out.println(Thread.currentThread().getName()+" is running:count="+count);
                if (count==5){
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, 0, 1000);
        System.out.println(Thread.currentThread().getName()+" is running");
    }
}

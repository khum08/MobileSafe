package com.kotlin.khum.mobilesafe.multiThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * <pre>
 *     author : khum
 *     desc   : 子线程把主线程传回主线程
 * </pre>
 */
public class Test8 {
    public static void main(String[] arg){
        FutureTask<String> futureTask = new FutureTask<>(new GetData());
        new Thread(futureTask).start();
        try {
            String data = futureTask.get();
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class GetData implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("i am getting from data from net");
        Thread.sleep(new Random().nextInt(5000));
        return "this is Data " + new Random().nextInt(1000);
    }
}

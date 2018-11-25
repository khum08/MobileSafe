package com.kotlin.khum.mobilesafe.multiThread;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * <pre>
 *     author : yuanzhenkun
 *     desc   :
 * </pre>
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class CountTask extends RecursiveTask<Integer> {

    private final int start;
    private final int end;
    private static final int THRESHODE = 200;

    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHODE;
        if (canCompute){
            for(int i = start; i <= end; i++){
                sum += i;
            }
        }else{
            int middle = start + ((end - start)>>1);
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle+1, end);
            leftTask.fork();
            rightTask.fork();
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] arg){
        int testEnd = 100000;
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(-testEnd, testEnd);
        ForkJoinTask<Integer> result = forkJoinPool.submit(countTask);
        try {
            System.out.println("ForkJoin:"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long start1 = System.currentTimeMillis();
        System.out.println("ForkJoin:"+(end-start));
        int sum = 0;
        for(int i = -testEnd; i <= testEnd; i++){
            sum += i;
        }
        System.out.println("Loop:"+sum);
        long end1 = System.currentTimeMillis();
        System.out.println("Loop:"+String.valueOf((end1 - start1)));
    }


}

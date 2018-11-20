package com.kotlin.khum.mobilesafe.multiThread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/20
 *     desc   :
 * </pre>
 */
public class ProducerAndConsumer {

    public static void main(String[] arg){
        Queue<Integer> queue = new LinkedList<>();
        Producer2 producer = new Producer2(queue);
        Consumer consumer = new Consumer(queue);
        consumer.start();
        producer.start();
    }

}

class Producer2 extends Thread{
    public static final int MAX_SIZE = 10;
    Queue<Integer> mQueue;
    public Producer2(Queue<Integer> queue){
        this.mQueue = queue;
    }

    @Override
    public void run() {
        produce();
    }

    public void produce(){
        while (true){
            synchronized (mQueue){
                while (mQueue.size()== MAX_SIZE){
                    mQueue.notify();
                    try {
                        mQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前队列满");
                }
                mQueue.add(1);
                mQueue.notify();
                System.out.println("生产者生产一条任务，当前队列长度为" + mQueue.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer extends Thread{

    Queue<Integer> mQueue;
    public Consumer(Queue<Integer> queue){
        this.mQueue = queue;
    }
    @Override
    public void run() {
        consume();
    }

    private void consume() {
        while (true){
            synchronized (mQueue){
                if (mQueue.size() == 0){
                    mQueue.notify();
                    System.out.println("当前队列为空");
                    try {
                        mQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mQueue.poll();
                    mQueue.notify();
                    System.out.println("消费者消费一条任务，当前队列长度为" + mQueue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

package com.kotlin.khum.mobilesafe.multiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class ProducerAndConsumer2 {

    public static void main(String[] arg){
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(60);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable{

        private final BlockingQueue<String> blockingQueue;

        public Producer(BlockingQueue<String> blockingQueue){
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            for(int i = 0; i < 200; i++){
                try {
                    Thread.sleep(5L);
                    String msg = "message"+i;
                    System.out.println("Produced new item:"+msg);
                    blockingQueue.put(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Time to say goodbye!");
            try {
                blockingQueue.put("Exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable{

        private final BlockingQueue<String> blockingQueue;

        public Consumer(BlockingQueue<String> blockingQueue){
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            try{
                String msg = null;
                while(!"Exit".equalsIgnoreCase((msg = blockingQueue.take()))){
                    System.out.println("Consumed item:"+msg);
                    Thread.sleep(10L);
                }
                System.out.println("Got exit message, bye!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}

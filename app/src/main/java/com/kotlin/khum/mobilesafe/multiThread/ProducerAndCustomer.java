package com.kotlin.khum.mobilesafe.multiThread;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class ProducerAndCustomer {
    static Random sRandom = new Random();

    public static void main(String[] arg){
        Hub hub = new Hub(60);
        Producer producer = new Producer(hub);
        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 20; i++){
                    try {
                        Thread.sleep(sRandom.nextInt(10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Customer customer = new Customer(hub);
                    hub.connect(customer);
                }
            }
        }.start();

        TimerTask task = new TimerTask(){
            @Override
            public void run() {
//                System.out.println("timetask is running");
                producer.produce();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 1000);
    }

}

//仓库
class Hub{

    private int capacity = 60;//仓库容量
    private int size; //仓库实际大小
    ArrayBlockingQueue<Customer> mQueue;
    public Hub(int capacity){
        this.capacity = capacity;
        mQueue = new ArrayBlockingQueue<>(60);
        new Thread(){
            @Override
            public void run() {
                consume();
            }
        }.start();
    }

    public void connect(Customer customer){
        mQueue.add(customer);
    }

    //生产
    synchronized void produce(){
        try{
            while (size>=capacity){
                wait();
            }
            size++;
            System.out.println("produced; current size is "+ size);
            notify();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //消费
    synchronized void consume() {
        while (true) {
            if (size<=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Customer poll = null;
            try {
                poll = mQueue.take();
            } catch (InterruptedException e) {
                notify();
                e.printStackTrace();
            }
            size = poll.consume(size);
            if (size<60){
                notify();
            }
            System.out.println("consumed; current size is " + size);
        }
    }
}

class Producer{

    private final Hub hub;

    public Producer(Hub hub){
        this.hub = hub;
    }
    public void produce(){
        hub.produce();
    }
}
class Customer{

    private final Hub hub;

    public Customer(Hub hub){
        this.hub = hub;
    }
    public int consume(int size){
        --size;
        return size;
    }
}
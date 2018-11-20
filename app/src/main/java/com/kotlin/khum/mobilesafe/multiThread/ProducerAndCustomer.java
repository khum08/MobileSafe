package com.kotlin.khum.mobilesafe.multiThread;

import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * <pre>
 *     author : khum
 *     desc   :
 * </pre>
 */
public class ProducerAndCustomer {

    public static void main(String[] arg){
        Hub hub = new Hub(60);
        Producer producer = new Producer(hub);
        Customer customer;
        for(int i = 0; i < 20; i++){
            customer = new Customer(hub);
            hub.connect(customer);
        }
    }

}

//仓库
class Hub{

    private int capacity;//仓库容量
    private int size; //仓库实际大小
    ArrayBlockingQueue<Customer> mQueue;
    public Hub(int capacity){
        this.capacity = capacity;
        mQueue = new ArrayBlockingQueue<>(60);
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
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //消费
    synchronized void consume(){
        try{
            while (size<=0){
                wait();
            }
            mQueue.poll();
            size--;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Producer{

    private final Hub hub;

    public Producer(Hub hub){
        this.hub = hub;
    }
    public void produce(){
        TimerTask timerTask = new TimerTask(){

            @Override
            public void run() {

            }
        };
        new Thread(){
            @Override
            public void run() {
                hub.produce();
            }
        }.start();
    }
}
class Customer{

    private final Hub hub;

    public Customer(Hub hub){
        this.hub = hub;
    }
    public void consume(){
        new Thread(){
            @Override
            public void run() {
                hub.consume();
            }
        }.start();
    }
}
package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     desc   : 用数组实现队列
 *     如果实现环形队列
 *     这个类在边界上还有问题
 * </pre>
 */
public class ArrayQueue<E> {

    public static void main(String[] arg){
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
//        queue.enqueue("d");
        String s1 = queue.dequeue();
        String s2 = queue.dequeue();
        queue.enqueue("e");
        queue.enqueue("f");
        String s3 = queue.dequeue();
        System.out.println();

    }

    private Object[] elements;
    private final int capacity;
    private int head;
    private int tail;

    public ArrayQueue(){
        capacity = 16;
        elements = new Object[capacity];
    }
    public ArrayQueue(int capacity){
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    //入队
    public boolean enqueue(E e){
        if (tail == capacity-1){
            if(head==0){
                return false;
            }
            //移动位置
            for(int i = head; i < tail; ++i){
                elements[i-head] = elements[i];
            }
            head = 0;
            tail = tail - head;
        }
        elements[tail++] = e;
        return true;
    }

    //出队
    public E dequeue(){
        //队满
        if (head>=tail)
            return null;
        return (E)elements[head++];
    }

}

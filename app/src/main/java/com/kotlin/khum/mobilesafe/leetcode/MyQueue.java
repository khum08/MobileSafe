package com.kotlin.khum.mobilesafe.leetcode;

import java.util.Stack;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/1
 *     desc   :
 * </pre>
 */
public class MyQueue {

    public static void main(String[] arg){
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(4);
        queue.push(5);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.peek());  // 返回 2
        System.out.println(queue.empty()); // 返回 false
    }
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.peek();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }
}

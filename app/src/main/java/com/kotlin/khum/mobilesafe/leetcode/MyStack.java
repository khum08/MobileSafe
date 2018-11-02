package com.kotlin.khum.mobilesafe.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/1
 *     desc   :
 * </pre>
 */
public class MyStack {

    public static void main(String[] arg){
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }

    private final Deque<Integer> data;
    /** Initialize your data structure here. */
    public MyStack() {
        data = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        data.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return data.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return data.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.isEmpty();
    }

}

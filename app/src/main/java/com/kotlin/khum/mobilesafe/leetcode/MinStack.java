package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/1
 *     desc   : 最小栈
 * </pre>
 */
public class MinStack {

    public static void main(String[] arg){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.
    }

    /** initialize your data structure here. */
    int[] elementData;
    int capacity = 16;
    int size = 0;
    int top;
    public MinStack() {
        elementData = new int[capacity];
    }

    public void push(int x) {
        ensureCapacity();
        top = x;
        elementData[size++] = x;
    }

    private void ensureCapacity() {
        if (size > capacity*0.75){
            capacity = capacity*2;
            int[] newData = new int[capacity];
            System.arraycopy(elementData, 0, newData, 0, size);
            elementData = newData;
        }
    }

    public void pop() {
        if (size==0){
            return;
        }else{
            size--;
            if (size>0){
                top = elementData[size-1];
            }
        }
    }

    public int top() {
        checkSize();
        return top;
    }

    public int getMin() {
        checkSize();
        int result = 0;
        for(int i = 0; i < size; i++){
           if (i==0){
               result = elementData[0];
           }else{
               result = Math.min(result, elementData[i]);
           }
        }
        return result;
    }

    private void checkSize(){
        if (size == 0){
            throw new UnsupportedOperationException("isEmpty");
        }
    }

}

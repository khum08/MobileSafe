package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : yuanzhenkun
 *     desc   : 数据结构--堆(一般都是基于数组)
 *     注意堆中第0个是空的
 * </pre>
 */

public class Heap {

    private int capacity;
    private int[] elementData;
    private int index = 1; //目前空的位置

    public Heap(){
        this.capacity = 20;
        this.elementData = new int[capacity];
    }

    public Heap(int capacity){
        this.capacity = capacity;
        this.elementData = new int[capacity];
    }

    //插入操作
    public void insert(int a){
        int temp = index;
        if (index < capacity){
            elementData[index++] = a;
        }else{
            //todo 扩容
        }
        //重新堆化
        while(temp > 0 && elementData[temp] > elementData[temp/2]){
            swap(temp , temp/2);
            temp = temp>>1;
        }
    }

    //交换数组中的两个数
    private void swap(int index1, int index2){
        int temp = elementData[index1];
        elementData[index1] = elementData[index2];
        elementData[index2] = temp;
    }


    //删除堆顶元素
    public void removeMax(){
        if (index < 2) {
            index--;
            return;
        }
        //1角标的数最大，和最后一个交换，并移除最后一个
        swap(1, index-1);
        index--;

        //重新堆化
        heapify();
    }

    //自上而下的堆化
    private void heapify() {
        int temp = index;
        while(true){
            int maxPos = temp;
            if ( temp*2 < index && elementData[temp] < elementData[temp*2]){
                maxPos = temp << 1;
            }
            if ( temp<<1+1 < index && elementData[maxPos] < elementData[temp*2+1]){
                maxPos = temp << 1 +1;
            }
            if (maxPos==temp){
                break;
            }
            swap(maxPos, temp);
            temp = maxPos;
        }

    }


}

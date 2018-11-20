package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     desc   : 排序
 * </pre>
 */
public class Sort {

    public static void main(String[] arg){
        int[] list = {1,2,5,3,9,6,7};
        traversal(list);
        bubbleSort(list);
        traversal(list);
    }

    //冒泡排序
    public static void bubbleSort(int[] list){
        int length = list.length;
        int temp;
        for(int i = 0; i < length; ++i){
            for(int j = i; j < length-i-1; ++j){
                if (list[j] > list[j+1]){
                    temp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] list){
        int length = list.length;
        if (length<=1) return;
        int value;
        for(int i = 1; i < length; ++i){
            value = list[i];
            int j = i-1;
            for(; j>=0; --j){
                if (list[j] > value){
                    list[j+1] = list[j];
                } else{
                    break;
                }
            }
            list[j+1] = value;
        }
    }

    //选择排序
    public static void selectSort(int[] list){

    }

    public static void traversal(int[] list){
        for(int a: list){
            System.out.println(a);
        }
    }
}

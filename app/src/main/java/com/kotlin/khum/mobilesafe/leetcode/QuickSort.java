package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     desc   : 快排，分治的思想
 * </pre>
 */
public class QuickSort {

    public static void main(String[] args){
        int[] list = {43,25,60,97,80,32};
        traversal(list);
        quickSort(list, 0, list.length-1);
        System.out.println();
        traversal(list);
    }

    private static void traversal(int[] list){
        for (int temp: list
                ) {
            System.out.print(temp);
            System.out.print("-");
        }
    }


    private static void quickSort(int[] list, int low, int high){
        if (high>low){
            int middle = part(list, low, high);
            quickSort(list, low, middle-1);
            quickSort(list, middle+1, high);
        }
    }

    private static int part(int[] list, int i, int j){
        int base = list[i]; //中轴
        while(i<j){
            while(i<j && list[j] > base){
                j--;
            }
            list[i] = list[j]; //比中轴小的放到左边
            while(i<j && list[i] < base){
                i++;
            }
            list[j] = list[i]; //比中轴大的放到右端
        }
        list[i] = base;
        return i;
    }

}

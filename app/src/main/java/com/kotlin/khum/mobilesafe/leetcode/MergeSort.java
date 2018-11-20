package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     desc   : 归并排序，分治的思想
 * </pre>
 */
public class MergeSort {

    public static void main(String[] arg){

    }

    static void mergeSort(int[] list, int start, int end){
        if (start<end){
            int middle = start + ((end - start)>>1);
            mergeSort(list, start, middle);
            mergeSort(list, middle+1, end);
            merge(list, start, middle, end);
        }
    }

    static void merge(int[] list, int start, int middle, int end){
        int[] temp = new int[end - start +1];
        int i = start;
        int j = middle + 1;
        int k = 0;
        while (i<= middle && j<= end){
            if (list[i] <= list[j]){
                temp[k++] = list[i++];
            }else{
                temp[k++] = list[j++];
            }
        }
        int p,q;
        if (j <= end){
            p = j;
            q = end;
        }else{
            p = i;
            q = middle;
        }
        while ( p <= q){
            temp[k++] = list[p++];
        }
        //复制回去, 这里可以优化
        for(int x = 0; x < temp.length; ++x){
            list[x] = temp[x];
        }
    }


}

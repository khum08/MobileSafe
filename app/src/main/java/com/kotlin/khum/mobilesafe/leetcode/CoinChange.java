package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     desc   : 贪心算法
 * </pre>
 */
public class CoinChange {

    public static void main(String[] arg){
        int[] values = { 1, 2, 5, 10, 20, 50, 100 };
        //各种面值对应数量集合
        int[] counts = { 3, 1, 2, 1, 1, 3, 5 };
        //求442元人民币需各种面值多少张
        int[] nums = change(4430, values, counts);
        print(values, nums);
    }

    static int[] change(int money, int[] values, int[] counts) {
        int[] result = new int[values.length];
        int num;
        for(int i = values.length-1; i>=0; i--){
            num = Math.min(money/values[i], counts[i]);
            money = money - num*values[i];
            result[i] = num;
        }
        return result;
    }

    static void print(int[] values, int[] num){
        for(int i = 0; i < values.length; i++){
            if (num[i]!=0){
                System.out.println("面值为"+values[i]+"的"+num[i]+"张");
            }
        }
    }
}

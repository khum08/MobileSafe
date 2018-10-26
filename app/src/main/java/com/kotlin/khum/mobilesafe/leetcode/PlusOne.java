package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/17
 *     desc   :
 * </pre>
 */
public class PlusOne {

    public static void main(String[] arg){
        int[] test1 = {1,2,3};
        int[] test2 = {1,8,9};
        int[] test3 = {9,9};
        PlusOne tool = new PlusOne();
        int[] r1 = tool.plusOne(test1);
        int[] r2 = tool.plusOne(test2);
        int[] r3 = tool.plusOne(test3);
        System.out.println(tool.plusOne(test3));
    }


    public int[] plusOne(int[] digits) {
        int frontNum = 0;
        int num;
        int length_1 = digits.length-1;
        for(int i = length_1; i>=0; i--){
            if(i==length_1){
                num = digits[i]+1;
            }else{
                num = digits[i]+frontNum;
            }
            if(num>9){
                digits[i] = 0;
                frontNum = 1;
            }else{
                digits[i] = num;
                frontNum = 0;
                break;
            }
        }
        if(frontNum==1){
            int[] target = new int[length_1+2];
            target[0] = 1;
            return target;
        }
        return digits;
    }
}

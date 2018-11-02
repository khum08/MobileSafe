package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/1
 *     desc   :
 * </pre>
 */
public class IsPowerOfTwo {

    public static void main(String[] arg){
//        System.out.println(isPowerOfTwo(2));
//        System.out.println(isPowerOfTwo(4));
//        System.out.println(isPowerOfTwo(6));
//        System.out.println(isPowerOfTwo(8));
//        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(256));
    }

    public static boolean isPowerOfTwo(int n) {
        int temp;
        boolean result = false;
        for(int i = 0; i < 32; i++){
            temp = 1 << i;
            if (temp > n ){
                break;
            }
            if (temp == n){
                result = true;
                break;
            }
        }
        return result;
    }

}

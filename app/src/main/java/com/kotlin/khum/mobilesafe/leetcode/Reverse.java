package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/16
 *     desc   :
 * </pre>
 */
public class Reverse {
    public static void main(String[] arg){
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(1534236469));
        System.out.println(reverse.reverse(-145));
    }

    public int reverse(int x) {
        if (x > 0) {
            return Integer.parseInt(positiveReverse(x));
        }else {
            return -Integer.parseInt(positiveReverse(-x));
        }
    }

    public String positiveReverse(int x){
        char[] chars = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length-1; i>=0; i--){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}

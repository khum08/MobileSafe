package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/16
 *     desc   :
 * </pre>
 */
public class IsPalindrome {
    public static void main(String[] arg){
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(121);
    }

    public boolean isPalindrome(int x) {
        boolean result = true;
        if (x==0){
            result = true;
        }else if(x>0){
            char[] chars = String.valueOf(x).toCharArray();
            int length = chars.length;
            int m = length/2;
            for(int i =0; i<m; i++){
                if (chars[i] != chars[length-1-i]){
                    result = false;
                    break;
                }
            }
        }else if(x<0){
            result = false;
        }

        return result;
    }
}

package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     desc   : 回溯算法
 * </pre>
 */
public class BackTracking {

    public static void main(String[] arg){
        allKindsOfSorts();
    }

    //给一个字符串，给出他的所有排列
    static void allKindsOfSorts(){
        String test = "abcd";
        pailie(test,"");
    }
    static void pailie(String s, String temp){
        if (s.length() == 0){
            System.out.println(temp);
            return;
        }
        for(int i=0; i<s.length(); i++){
            String newString = s.substring(0, i) + s.substring(i+1, s.length());
            pailie(newString, temp+s.charAt(i));
        }
    }


}

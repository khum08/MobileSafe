package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/16
 *     desc   :
 * </pre>
 */
public class StrStr {

    public static void main(String[] arg){
        String haystack = "hello", needle = "ll";
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        if (needleLength==0){
            return 0;
        }
        return haystack.indexOf(needle);
    }
}

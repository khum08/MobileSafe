package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/16
 *     desc   :
 * </pre>
 */
public class LongestCommonPrefix {

    public static void main(String[] arg){
        String[] strs = {"flower","flow","flight"};
        String[] strs1 = {"c","c"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String firstNode = strs[0];
        String pref = "";
        A:for(int i = firstNode.length(); i >=0; i-- ){
            pref = firstNode.substring(0, i);
            for(int j = 0; j < strs.length; j++){
                if (!strs[j].startsWith(pref)){
                    continue A;
                }
            }
            break;
        }
        return pref;
    }
}

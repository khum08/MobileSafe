package com.kotlin.khum.mobilesafe.leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/1
 *     desc   :
 * </pre>
 */
public class FindTheDifference {

    public static void main(String[] arg){
        String s = "abcdaafdsfasdfe";
        String t = "abcdaafdsffasdfe";
        FindTheDifference tool = new FindTheDifference();
        char theDifference = tool.findTheDifference(s, t);
        System.out.println(theDifference);
    }

    public char findTheDifference(String s, String t) {
        List<char[]> t_list = Arrays.asList(t.toCharArray());
        List<char[]> s_list = Arrays.asList(s.toCharArray());
        Iterator<char[]> t_itr = t_list.iterator();
        Iterator<char[]> s_itr = s_list.iterator();
        char temp = 'a';
        char[] temp_a;
        boolean over;
        while (t_itr.hasNext()){
            temp = t_itr.next()[0];
            over = true;
            while (s_itr.hasNext()){
                if (s_itr.next()[0] == temp){
                    s_itr.remove();
                    over = false;
                    break;
                }
            }
            if (over){
                break;
            }
        }
        return temp;
    }


    public char findTheDifference2(String s, String t) {
        char[] t_array = t.toCharArray();
        char[] s_array = t.toCharArray();
        char temp = 'a';
        boolean over = false;
        for(int i = 0; i < t_array.length; i++){
            temp = t_array[i];
            over = true;
            for(int j = 0; j < s_array.length; j++){
                if (temp == s_array[j]){
                    over = false;
                    break;
                }
            }
            if (over){
                break;
            }
        }
        return temp;
    }
}

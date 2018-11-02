package com.kotlin.khum.mobilesafe.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/11/1
 *     desc   :
 * </pre>
 */
public class SingleNumber {

    public static void main(String[] arg){
        int[] test1 = {2,2,1};
        int[] test2 = {4,1,2,1,2};
        SingleNumber tool = new SingleNumber();
        System.out.println(tool.singleNumber(test1));
        System.out.println(tool.singleNumber(test2));
        System.out.println();
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x: nums) {
            boolean add = set.add(x);
            if (!add){
                set.remove(x);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            return iterator.next();
        }
        return 0;
    }
}

package com.kotlin.khum.mobilesafe.leetcode;

import java.util.HashSet;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/17
 *     desc   :
 * </pre>
 */
public class IsHappy {

    public static void main(String[] arg){
        IsHappy tool = new IsHappy();
        boolean h1 = tool.isHappy(19);
        boolean h2 = tool.isHappy(11);
        boolean h3 = tool.isHappy(7);
        System.out.println(h1);
        System.out.println(h3);
    }

    int sum;
    private HashSet<Integer> set;
    boolean over;
    boolean isHappy;
    private void squareSum(int n){
        char[] chars = String.valueOf(n).toCharArray();
        sum = 0;
        A:if (!over){
            for(int i = 0; i < chars.length; i++){
                sum += (chars[i] -48)*(chars[i]-48);
            }
            if (sum==1){
                isHappy = true;
                over = true;
                break A;
            }
            boolean notExist = set.add(sum);
            if (!notExist){
                //存在这个数,不是快乐数，退出
                over = true;
                isHappy = false;
                break A;
            }
            squareSum(sum);
        }
    }

    public boolean isHappy(int n) {
        set = new HashSet();
        over = false;
        isHappy = false;
        squareSum(n);
        return isHappy;
    }
}

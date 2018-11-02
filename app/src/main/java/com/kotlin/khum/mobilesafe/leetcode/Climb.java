package com.kotlin.khum.mobilesafe.leetcode;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/10/16
 *     desc   :
 * </pre>
 */
public class Climb {

    public static void main(String[] arg){
        Climb climb = new Climb();
        System.out.println(climb.climbStairs(2));
    }

    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int[] times = new int[n+1];
        times[1] = 1;
        times[2] = 2;
        climb(times, n);
        return times[n];
    }

    private void climb(int[] times, int n){
        int x = n-1;
        int y = n-2;
        if (x>2) {
            climb(times, x);
        }
        if (y>2){
            climb(times, y);
        }
        times[n] = times[x]+times[y];

    }

}
